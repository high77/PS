import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == -1) break; // EOF 처리

            int[] x = new int[n];
            int[] y = new int[n];
            int[] z = new int[n];
            long[] packed = new long[n];

            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
                z[i] = sc.nextInt();
                // x좌표(최대 10^9, 30비트)를 상위 32비트에, 인덱스를 하위 32비트에 패킹하여 객체 없이 정렬
                packed[i] = ((long) x[i] << 32) | i;
            }

            Arrays.sort(packed);

            int[] sx = new int[n];
            int[] sy = new int[n];
            int[] sz = new int[n];

            for (int i = 0; i < n; i++) {
                int id = (int) (packed[i] & 0xFFFFFFFFL);
                sx[i] = x[id];
                sy[i] = y[id];
                sz[i] = z[id];
            }

            long d2 = Long.MAX_VALUE;

            // 중앙에 위치한 점을 기준으로 초기 최소 거리(상한선)를 매우 좁게 설정
            int mid = n / 2;
            int mx = sx[mid], my = sy[mid], mz = sz[mid];
            for (int i = 0; i < n; i++) {
                if (i == mid) continue;
                long dx = mx - sx[i];
                long dy = my - sy[i];
                long dz = mz - sz[i];
                long dist2 = dx * dx + dy * dy + dz * dz;
                if (dist2 < d2) {
                    d2 = dist2;
                }
            }

            // 스위핑 알고리즘
            for (int i = 0; i < n; i++) {
                int ix = sx[i], iy = sy[i], iz = sz[i];
                for (int j = i + 1; j < n; j++) {
                    long dx = sx[j] - ix;
                    // X축 차이가 현재 최소 거리 이상이면 더 먼 점들만 남았으므로 즉시 break
                    if (dx * dx >= d2) break;

                    long dy = sy[j] - iy;
                    // Y축 차이가 최소 거리 이상이면 제외
                    if (dy * dy >= d2) continue;

                    long dz = sz[j] - iz;
                    // Z축 차이가 최소 거리 이상이면 제외
                    if (dz * dz >= d2) continue;

                    long dist2 = dx * dx + dy * dy + dz * dz;
                    if (dist2 < d2) {
                        d2 = dist2;
                    }
                }
            }

            System.out.printf(Locale.US, "%.10f\n", Math.sqrt(d2));
        }
    }

    // 대규모 데이터 입력 처리를 위한 커스텀 스캐너
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