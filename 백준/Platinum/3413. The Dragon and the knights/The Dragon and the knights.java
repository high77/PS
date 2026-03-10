import java.io.*;
import java.util.*;

public class Main {
    // 입력을 빠르게 읽기 위한 클래스
    static class FastReader {
        private InputStream in;
        private byte[] buffer = new byte[1024 * 8];
        private int pointer = 0;
        private int bufferLength = 0;

        public FastReader(InputStream in) { this.in = in; }

        private int read() throws IOException {
            if (pointer >= bufferLength) {
                pointer = 0;
                bufferLength = in.read(buffer);
                if (bufferLength <= 0) return -1;
            }
            return buffer[pointer++];
        }

        public int nextInt() throws IOException {
            int c = read();
            while (c >= 0 && c <= 32) c = read();
            if (c == -1) return 0;
            int neg = 1;
            if (c == '-') { neg = -1; c = read(); }
            int res = 0;
            while (c >= '0' && c <= '9') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res * neg;
        }

        public long nextLong() throws IOException {
            int c = read();
            while (c >= 0 && c <= 32) c = read();
            int neg = 1;
            if (c == '-') { neg = -1; c = read(); }
            long res = 0;
            while (c >= '0' && c <= '9') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res * neg;
        }
    }

    // 두 개의 long 값을 기준으로 정렬하기 위한 인덱스 정렬
    static void sortSignatures(int m, long[] low, long[] high, Integer[] idx) {
        Arrays.sort(idx, (a, b) -> {
            if (low[a] != low[b]) return Long.compare(low[a], low[b]);
            return Long.compare(high[a], high[b]);
        });
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader(System.in);
        int T = fr.nextInt();
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = fr.nextInt();
            int m = fr.nextInt();

            long[] A = new long[n];
            long[] B = new long[n];
            long[] C = new long[n];
            for (int i = 0; i < n; i++) {
                A[i] = fr.nextLong();
                B[i] = fr.nextLong();
                C[i] = fr.nextLong();
            }

            // 1. 영역의 수 계산
            long intersections = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (A[i] * B[j] != A[j] * B[i]) intersections++;
                }
            }
            long totalRegions = 1 + n + intersections;

            // 2. 기사들의 Signature 계산 (Primitive arrays 사용)
            long[] low = new long[m];
            long[] high = new long[m];
            Integer[] idx = new Integer[m];

            for (int i = 0; i < m; i++) {
                long x = fr.nextLong();
                long y = fr.nextLong();
                idx[i] = i;
                for (int j = 0; j < n; j++) {
                    if (A[j] * x + B[j] * y + C[j] > 0) {
                        if (j < 64) low[i] |= (1L << j);
                        else high[i] |= (1L << (j - 64));
                    }
                }
            }

            // 3. 정렬 후 중복 제거된 개수 세기 (HashSet 대체)
            sortSignatures(m, low, high, idx);

            int occupiedCount = (m > 0) ? 1 : 0;
            for (int i = 1; i < m; i++) {
                int curr = idx[i];
                int prev = idx[i - 1];
                if (low[curr] != low[prev] || high[curr] != high[prev]) {
                    occupiedCount++;
                }
            }

            if (occupiedCount == totalRegions) {
                sb.append("PROTECTED\n");
            } else {
                sb.append("VULNERABLE\n");
            }
        }
        System.out.print(sb);
    }
}