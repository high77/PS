import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] px = new int[n + 1];
        int[] py = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            px[i] = sc.nextInt();
            py[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < q; j++) {
            int qx = sc.nextInt();
            int qy = sc.nextInt();

            long minDist = Long.MAX_VALUE;
            int count = 0;
            int id1 = 0;
            int id2 = 0;

            for (int i = 1; i <= n; i++) {
                long dx = px[i] - qx;
                long dy = py[i] - qy;
                long dist = dx * dx + dy * dy;

                if (dist < minDist) {
                    minDist = dist;
                    count = 1;
                    id1 = i;
                } else if (dist == minDist) {
                    count++;
                    if (count == 2) {
                        id2 = i;
                    }
                }
            }

            if (count == 1) sb.append("REGION ").append(id1).append("\n");
            else if (count == 2) sb.append("LINE ").append(id1).append(" ").append(id2).append("\n");
            else sb.append("POINT\n");
        }
        System.out.println(sb);
    }

    // 대규모 데이터 및 음수 좌표 처리를 위한 커스텀 스캐너
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
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return negative ? -res : res;
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