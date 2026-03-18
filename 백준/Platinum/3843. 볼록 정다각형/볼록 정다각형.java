import java.io.*;
import java.util.*;

public class Main {
    // 빈 줄 등 불규칙한 입력 형식을 안전하게 무시하는 FastScanner
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = sc.next();
            if (s == null || s.equals("END")) break;

            double x1 = Double.parseDouble(s);
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double x3 = sc.nextDouble();
            double y3 = sc.nextDouble();

            // 삼각형의 세 내각을 atan2를 이용해 가장 안전하고 정확하게 계산
            double A = angleBetween(x1, y1, x2, y2, x3, y3);
            double B = angleBetween(x2, y2, x1, y1, x3, y3);
            double C = angleBetween(x3, y3, x1, y1, x2, y2);

            int best_n = 3;
            double min_err = Double.MAX_VALUE;

            // 3각형부터 1000각형까지 전부 테스트하여 오차가 가장 작은 n을 채택
            for (int n = 3; n <= 1000; n++) {
                double err = 0;

                for (double angle : new double[]{A, B, C}) {
                    // 해당 각도에 가장 가까운 pi/n의 배수를 찾음
                    double expected = Math.round(angle * n / Math.PI) * Math.PI / n;
                    err += Math.abs(angle - expected);
                }

                // 기존 최솟값보다 '확실하게' 작을 때만 갱신 (1e-7 마진)
                // 이를 통해 정답이 4각형일 때 8각형 등 배수 다각형으로 오답이 덮어씌워지는 것을 완벽 차단
                if (err < min_err - 1e-7) {
                    min_err = err;
                    best_n = n;
                }
            }
            sb.append(best_n).append("\n");
        }
        System.out.println(sb);
    }

    // 꼭짓점(cx, cy)에서 다른 두 점 사이의 끼인각을 구하는 메서드
    static double angleBetween(double cx, double cy, double x1, double y1, double x2, double y2) {
        double a1 = Math.atan2(y1 - cy, x1 - cx);
        double a2 = Math.atan2(y2 - cy, x2 - cx);
        double diff = Math.abs(a1 - a2);

        // 두 각의 차이가 180도를 넘으면 반대쪽 예각/둔각을 취함
        if (diff > Math.PI) {
            diff = 2 * Math.PI - diff;
        }
        return diff;
    }
}