import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long[] X = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                X[i] = Long.parseLong(st.nextToken());
            }

            // 1. 점들의 위치를 오름차순 정렬
            Arrays.sort(X);

            int count = 0;
            for (int i = 0; i < N - 2; i++) {
                for (int j = i + 1; j < N - 1; j++) {
                    long target = 2 * X[j] - X[i];

                    if (binarySearch(X, j + 1, N - 1, target)) {
                        count++;
                    }
                }
            }
            ans.append(count).append("\n");
        }
        System.out.println(ans);
    }

    // 이진 탐색 함수
    static boolean binarySearch(long[] arr, int low, int high, long target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}