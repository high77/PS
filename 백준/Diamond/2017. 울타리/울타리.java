import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    // 시야를 나타내는 방향 벡터 클래스
    static class Ray implements Comparable<Ray> {
        long dx, dy;
        int q; // 사분면
        boolean isMin, isMax; // 시작과 끝을 나타내는 가상 극한값

        public Ray(boolean isMin, boolean isMax) {
            this.isMin = isMin;
            this.isMax = isMax;
        }

        public Ray(long dx, long dy) {
            set(dx, dy);
        }

        // 객체 재사용을 위한 갱신 메서드 (메모리 최적화 핵심)
        public void set(long dx, long dy) {
            this.dx = dx;
            this.dy = dy;
            if (dx > 0 && dy >= 0) q = 1;
            else if (dx <= 0 && dy > 0) q = 2;
            else if (dx < 0 && dy <= 0) q = 3;
            else q = 4;
        }

        @Override
        public int compareTo(Ray o) {
            if (this.isMin) return o.isMin ? 0 : -1;
            if (o.isMin) return 1;
            if (this.isMax) return o.isMax ? 0 : 1;
            if (o.isMax) return -1;

            // 사분면이 다르면 사분면 순서대로 정렬
            if (this.q != o.q) return this.q - o.q;

            // 사분면이 같으면 외적(Cross Product)을 통해 CCW 여부로 정확히 정렬 (오차 0)
            long cp = this.dx * o.dy - this.dy * o.dx;
            if (cp > 0) return -1; // this가 o보다 CCW상 앞에 있음 (각도가 작음)
            if (cp < 0) return 1;
            return 0; // 정확히 일직선
        }
    }

    // 스위핑을 위한 이벤트 클래스
    static class Event implements Comparable<Event> {
        Ray ray;
        int type; // 0: 시작(START), 2: 끝(END)

        public Event(Ray ray, int type) {
            this.ray = ray;
            this.type = type;
        }

        @Override
        public int compareTo(Event o) {
            int cmp = this.ray.compareTo(o.ray);
            if (cmp != 0) return cmp;
            return this.type - o.type; // 동일한 각도일 경우 시작이 먼저
        }
    }

    // 가려진 시야 구간
    static class Interval {
        Ray start, end;
        public Interval(Ray start, Ray end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        long Fx = sc.nextInt();
        long Fy = sc.nextInt();

        Ray MIN_RAY = new Ray(true, false);
        Ray MAX_RAY = new Ray(false, true);

        List<Event> events = new ArrayList<>(r * 4);

        for (int i = 0; i < r; i++) {
            int p = sc.nextInt();
            long[] x = new long[p];
            long[] y = new long[p];
            double[] angles = new double[p];

            for (int j = 0; j < p; j++) {
                x[j] = sc.nextInt();
                y[j] = sc.nextInt();
                angles[j] = Math.atan2(y[j] - Fy, x[j] - Fx);
            }

            double minA = angles[0], maxA = angles[0];
            for (int j = 1; j < p; j++) {
                if (angles[j] < minA) minA = angles[j];
                if (angles[j] > maxA) maxA = angles[j];
            }

            // 바위가 음의 x축(각도 -pi 와 pi의 경계)을 겹쳐서 존재하는 경우 각도 보정
            if (maxA - minA > Math.PI) {
                for (int j = 0; j < p; j++) {
                    if (angles[j] < 0) angles[j] += 2 * Math.PI;
                }
                minA = angles[0]; maxA = angles[0];
                for (int j = 1; j < p; j++) {
                    if (angles[j] < minA) minA = angles[j];
                    if (angles[j] > maxA) maxA = angles[j];
                }
            }

            int minIdx = 0, maxIdx = 0;
            for (int j = 0; j < p; j++) {
                if (angles[j] == minA) minIdx = j;
                if (angles[j] == maxA) maxIdx = j;
            }

            Ray right = new Ray(x[minIdx] - Fx, y[minIdx] - Fy); // 시야가 가려지기 시작하는 오른쪽 경계
            Ray left = new Ray(x[maxIdx] - Fx, y[maxIdx] - Fy);  // 시야가 끝나는 왼쪽 경계

            // 구간이 양의 x축(시작점)을 넘어가며 감싸는 경우 두 구간으로 분할
            if (right.compareTo(left) <= 0) {
                events.add(new Event(right, 0));
                events.add(new Event(left, 2));
            } else {
                events.add(new Event(right, 0));
                events.add(new Event(MAX_RAY, 2));
                events.add(new Event(MIN_RAY, 0));
                events.add(new Event(left, 2));
            }
        }

        // 스위핑 정렬
        Collections.sort(events);

        // 겹치는 시야 구간 병합
        List<Interval> merged = new ArrayList<>();
        int active = 0;
        Ray start = null;
        for (Event e : events) {
            if (e.type == 0) {
                if (active == 0) start = e.ray;
                active++;
            } else {
                active--;
                if (active == 0) {
                    merged.add(new Interval(start, e.ray));
                }
            }
        }

        int visible = 0;
        Ray probe = new Ray(0, 0); // 200만번 테스트하기 위해 단 1번만 할당되는 객체

        // 밭 둘레의 4면 4N개의 말뚝 순회 (각 모서리가 중복 계산되지 않도록 깔끔하게 분리)
        for (int x = 0; x < n; x++) visible += isBlocked(x, 0, Fx, Fy, probe, merged) ? 0 : 1;
        for (int y = 0; y < n; y++) visible += isBlocked(n, y, Fx, Fy, probe, merged) ? 0 : 1;
        for (int x = n; x > 0; x--) visible += isBlocked(x, n, Fx, Fy, probe, merged) ? 0 : 1;
        for (int y = n; y > 0; y--) visible += isBlocked(0, y, Fx, Fy, probe, merged) ? 0 : 1;

        System.out.println(visible);
    }

    // 이분 탐색을 이용해 말뚝이 병합된 사각지대 구간 내부에 있는지 확인하는 메서드
    static boolean isBlocked(long px, long py, long Fx, long Fy, Ray probe, List<Interval> merged) {
        probe.set(px - Fx, py - Fy);
        int left = 0, right = merged.size() - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            Interval iv = merged.get(mid);

            // probe가 [start, end] 구간에 정확히 포함되거나 경계에 겹치는 경우
            if (iv.start.compareTo(probe) <= 0 && probe.compareTo(iv.end) <= 0) {
                return true;
            }
            if (probe.compareTo(iv.start) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    // 막대한 입력을 빠르게 처리하기 위한 커스텀 FastScanner
    static class FastScanner {
        InputStream in;
        byte[] buffer = new byte[1 << 16];
        int head = 0, tail = 0;

        public FastScanner(InputStream in) {
            this.in = in;
        }

        public int nextInt() throws IOException {
            int c = read();
            while (c <= ' ' && c != -1) c = read();
            if (c == -1) return -1;
            boolean neg = (c == '-');
            if (neg) c = read();
            int res = 0;
            while (c > ' ' && c != -1) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return neg ? -res : res;
        }

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }
    }
}