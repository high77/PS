import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 김밥 개수
        long K = Long.parseLong(st.nextToken());  // 꼬다리 길이
        long M = Long.parseLong(st.nextToken());  // 목표 조각 개수

        long[] usableLengths = new long[N];
        int validCount = 0;
        long maxLen = 0;

        for (int i = 0; i < N; i++) {

            long L = Long.parseLong(br.readLine());
            long usable = 0;

            if (L >= 2 * K) usable = L - 2 * K;
            else if (L > K) usable = L - K;

            if (usable > 0) {
                usableLengths[validCount++] = usable;
                if (usable > maxLen) maxLen = usable;
            }
        }

        if (maxLen == 0) {
            System.out.println("-1");
            return;
        }

        long left = 1, right = maxLen;
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2, count = 0;

            for (int i = 0; i < validCount; i++) count += usableLengths[i] / mid;

            if (count >= M) {
                answer = mid;      // 조건 만족하므로 정답 후보 저장
                left = mid + 1;    // 더 긴 길이 시도
            } else {
                right = mid - 1;   // 길이를 줄여야 함
            }
        }

        System.out.println(answer);
    }
}