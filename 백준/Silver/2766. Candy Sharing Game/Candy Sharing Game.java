import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            int[] c = new int[n];
            for (int i = 0; i < n; i++) c[i] = sc.nextInt();

            int rounds = 0;
            while (true) {
                boolean allSame = true;
                for (int i = 1; i < n; i++) {
                    if (c[i] != c[0]) {
                        allSame = false;
                        break;
                    }
                }
                if (allSame) break;

                // 임시 배열 없이 In-place로 캔디 분배 계산
                int prevHalf = c[n - 1] / 2;
                for (int i = 0; i < n; i++) {
                    int curHalf = c[i] / 2;
                    c[i] = curHalf + prevHalf;
                    
                    // 홀수 판별 및 캔디 추가
                    if ((c[i] & 1) == 1) c[i]++;
                    
                    prevHalf = curHalf;
                }
                rounds++;
            }
            sb.append(rounds).append(" ").append(c[0]).append("\n");
        }
        System.out.print(sb);
    }

    // 커스텀 스캐너
    static class FastScanner {
        InputStream is;
        byte[] buf = new byte[1024 * 64];
        int head = 0, tail = 0;

        public FastScanner(InputStream is) { this.is = is; }

        public int nextInt() throws Exception {
            int c = read();
            while (c <= 32) { if (c == -1) return -1; c = read(); }
            int res = 0;
            while (c > 32) { res = res * 10 + c - '0'; c = read(); }
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