import java.io.InputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int[] arr = new int[1024];
        int size = 0;

        while (true) {
            int val = sc.nextInt();
            if (val == 0 || val == -1) break;

            // 동적 배열 확장 (인라인 조건문 적용)
            if (size == arr.length) arr = Arrays.copyOf(arr, arr.length * 2);
            arr[size++] = val;
        }

        Arrays.sort(arr, 0, size);

        for (int i = 0; i < size - 2; i++) {
            // int형 변수 2개의 합이 20억(2 * 10^9)을 초과할 수 있으므로 long 캐스팅 필수
            if ((long) arr[i] + arr[i + 1] > arr[i + 2]) {
                System.out.println(arr[i] + " " + arr[i + 1] + " " + arr[i + 2]);
                return;
            }
        }

        System.out.println("NIE");
    }

    // 대규모 데이터 처리에 최적화된 커스텀 스캐너
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