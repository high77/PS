import java.io.*;
import java.util.*;

public class Main {
    static class Interval implements Comparable<Interval> {
        double L, R;
        @Override
        public int compareTo(Interval o) {
            return Double.compare(this.L, o.L);
        }
    }

    static final double HALF_PI = Math.PI / 2.0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (!st.hasMoreTokens()) return;

        int N = Integer.parseInt(st.nextToken());

        double[] r = new double[N];
        double[] phi = new double[N];
        double minR = Double.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            // 캐스팅 오차가 없는 정확한 빗변 길이 계산
            r[i] = Math.hypot(x, y);
            if (r[i] < minR) {
                minR = r[i];
            }

            // 음수 모듈러 연산의 부작용을 방지하는 명시적 각도 보정
            double p = Math.atan2(y, x);
            while (p < 0) p += HALF_PI;
            while (p >= HALF_PI) p -= HALF_PI;
            phi[i] = p;
        }

        Interval[] intervals = new Interval[N * 2 + 5];
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = new Interval();
        }

        double low = 0;
        double high = minR;
        double ans = 0;

        // 정밀도 극한 확보를 위해 이분 탐색 횟수를 100회로 상향 (오차율 2^-100)
        for (int iter = 0; iter < 100; iter++) {
            double mid = (low + high) / 2.0;

            int count = 0;
            boolean possible = true;
            double sqrt2d = mid * 1.4142135623730951;

            for (int i = 0; i < N; i++) {
                if (r[i] < mid) {
                    possible = false;
                    break;
                }
                if (r[i] >= sqrt2d) continue;

                double ratio = mid / r[i];
                if (ratio > 1.0) ratio = 1.0;

                double gamma = Math.acos(ratio);
                double len = HALF_PI - 2 * gamma;

                if (len <= 0) continue;

                double L = phi[i] + gamma;
                if (L >= HALF_PI) L -= HALF_PI;
                double R = L + len;

                if (R >= HALF_PI) {
                    intervals[count].L = L;
                    intervals[count].R = HALF_PI;
                    count++;
                    intervals[count].L = 0;
                    intervals[count].R = R - HALF_PI;
                    count++;
                } else {
                    intervals[count].L = L;
                    intervals[count].R = R;
                    count++;
                }
            }

            if (!possible) {
                high = mid;
                continue;
            }

            Arrays.sort(intervals, 0, count);
            double currentR = 0;
            boolean hasGap = false;

            // Epsilon 제거: 이분 탐색이 한계점(Gap=0)까지 정확히 수렴하도록 유도
            for (int i = 0; i < count; i++) {
                if (intervals[i].L > currentR) {
                    hasGap = true;
                    break;
                }
                if (intervals[i].R > currentR) {
                    currentR = intervals[i].R;
                }
            }

            if (currentR < HALF_PI) {
                hasGap = true;
            }

            if (hasGap) {
                ans = mid;
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.printf(Locale.US, "%.4f\n", ans * 8.0);
    }
}