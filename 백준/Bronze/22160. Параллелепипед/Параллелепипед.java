import java.io.InputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int[] edges = new int[12];
            boolean allZero = true;
            boolean isEOF = false;
            
            for (int i = 0; i < 12; i++) {
                int val = sc.nextInt();
                if (val == -1) {
                    isEOF = true;
                    break;
                }
                edges[i] = val;
                if (edges[i] != 0) {
                    allZero = false;
                }
            }
            
            // 파일 끝에 도달했거나 12개가 모두 0인 경우 종료
            if (isEOF || allZero) break;

            // 오름차순 정렬
            Arrays.sort(edges);

            // 4개씩 3그룹의 길이가 동일한지 판별
            if (edges[0] == edges[3] && edges[4] == edges[7] && edges[8] == edges[11]) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.print(sb);
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