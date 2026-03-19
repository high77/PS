import java.io.*;
import java.util.*;

public class Main {
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            long[] P = new long[n];
            for (int i = 0; i < n; i++) {
                P[i] = pack(sc.nextInt(), sc.nextInt());
            }

            // 이분 탐색을 위한 배열 정렬
            Arrays.sort(P);

            int count = 0;
            for (int i = 0; i < n; i++) {
                // 패킹된 long 데이터에서 x, y 복원
                int x1 = (int) (P[i] >> 32);
                int y1 = (int) P[i];

                for (int j = i + 1; j < n; j++) {
                    int x2 = (int) (P[j] >> 32);
                    int y2 = (int) P[j];

                    int dx = x2 - x1;
                    int dy = y2 - y1;

                    // 1. 기준 선분 기준 왼쪽 정사각형 검사
                    if (Arrays.binarySearch(P, pack(x2 - dy, y2 + dx)) >= 0 &&
                            Arrays.binarySearch(P, pack(x1 - dy, y1 + dx)) >= 0) {
                        count++;
                    }

                    // 2. 기준 선분 기준 오른쪽 정사각형 검사
                    if (Arrays.binarySearch(P, pack(x2 + dy, y2 - dx)) >= 0 &&
                            Arrays.binarySearch(P, pack(x1 + dy, y1 - dx)) >= 0) {
                        count++;
                    }
                }
            }

            // 각 정사각형은 4개의 변에 의해 4번 중복 발견되므로 4로 나눔
            sb.append(count / 4).append("\n");
        }
        System.out.print(sb);
    }

    // x, y 좌표를 하나의 long 값으로 압축하는 메서드
    static long pack(int x, int y) {
        return ((long) x << 32) | (y & 0xFFFFFFFFL);
    }
}