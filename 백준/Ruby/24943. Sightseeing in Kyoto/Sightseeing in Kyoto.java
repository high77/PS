import java.io.InputStream;
import java.util.Arrays;

public class Main {
    static class Segment implements Comparable<Segment> {
        long dy;
        int dx;
        boolean isA; // true면 행(r) 이동 유발, false면 열(c) 이동 유발

        public Segment(long dy, int dx, boolean isA) {
            this.dy = dy;
            this.dx = dx;
            this.isA = isA;
        }

        @Override
        public int compareTo(Segment o) {
            // 기울기(dy/dx) 비교를 나눗셈 오차 없이 교차 곱으로 수행
            long lhs = this.dy * o.dx;
            long rhs = o.dy * this.dx;
            return Long.compare(lhs, rhs);
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();

        long[] A = new long[H + 1];
        for (int i = 1; i <= H; i++) A[i] = sc.nextInt();

        long[] B = new long[W + 1];
        for (int i = 1; i <= W; i++) B[i] = sc.nextInt();

        // 1. A 배열의 하단 볼록 껍질 구성
        int[] hullA = new int[H + 1];
        int topA = 0;
        hullA[++topA] = 1;
        for (int i = 2; i <= H; i++) {
            while (topA >= 2) {
                int p2 = hullA[topA];
                int p1 = hullA[topA - 1];
                // 기울기 비교: (A[p2] - A[p1]) / (p2 - p1) >= (A[i] - A[p2]) / (i - p2)
                if ((A[p2] - A[p1]) * (i - p2) >= (A[i] - A[p2]) * (p2 - p1)) {
                    topA--; // 이전 정점이 볼록성을 해치므로 제거
                } else {
                    break;
                }
            }
            hullA[++topA] = i;
        }

        // 2. B 배열의 하단 볼록 껍질 구성
        int[] hullB = new int[W + 1];
        int topB = 0;
        hullB[++topB] = 1;
        for (int i = 2; i <= W; i++) {
            while (topB >= 2) {
                int p2 = hullB[topB];
                int p1 = hullB[topB - 1];
                if ((B[p2] - B[p1]) * (i - p2) >= (B[i] - B[p2]) * (p2 - p1)) {
                    topB--;
                } else {
                    break;
                }
            }
            hullB[++topB] = i;
        }

        // 3. 껍질 정점들로 선분(기울기) 객체 생성
        Segment[] segments = new Segment[(topA - 1) + (topB - 1)];
        int segIdx = 0;
        for (int i = 1; i < topA; i++) {
            int p1 = hullA[i];
            int p2 = hullA[i + 1];
            segments[segIdx++] = new Segment(A[p2] - A[p1], p2 - p1, true);
        }
        for (int i = 1; i < topB; i++) {
            int p1 = hullB[i];
            int p2 = hullB[i + 1];
            segments[segIdx++] = new Segment(B[p2] - B[p1], p2 - p1, false);
        }

        // 4. 기울기 오름차순 정렬
        Arrays.sort(segments);

        // 5. 그리디 이동에 따른 비용 누적 계산
        long totalCost = 0;
        int currentR = 1;
        int currentC = 1;

        for (Segment seg : segments) {
            if (seg.isA) {
                // A-선분 선택: 행(Row)을 아래로 진행 (수직 이동)
                totalCost += (long) B[currentC] * seg.dx;
                currentR += seg.dx;
            } else {
                // B-선분 선택: 열(Col)을 우측으로 진행 (수평 이동)
                totalCost += (long) A[currentR] * seg.dx;
                currentC += seg.dx;
            }
        }

        System.out.println(totalCost);
    }

    // 커스텀 I/O 최적화 클래스 (대량 입력 처리용)
    static class FastScanner {
        InputStream is;
        byte[] buf = new byte[1024 * 64];
        int head = 0, tail = 0;

        public FastScanner(InputStream is) {
            this.is = is;
        }

        public int nextInt() throws Exception {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }

        private int read() throws Exception {
            if (head >= tail) {
                head = 0;
                tail = is.read(buf, 0, buf.length);
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }
    }
}