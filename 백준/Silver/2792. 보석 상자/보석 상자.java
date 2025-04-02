import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        int l = 1, r = 0, ans = 0;

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(in.readLine());
            if (arr[i] > r) r = arr[i];  // 최대값 갱신
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            int sum = 0;

            for (int i = 0; i < M; i++) {
                sum += (arr[i] + mid - 1) / mid;
            }

            if (sum > N) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}
