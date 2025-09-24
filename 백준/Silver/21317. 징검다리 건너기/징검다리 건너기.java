import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] small = new int[N];
        int[] big = new int[N];
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            small[i] = Integer.parseInt(st.nextToken());
            big[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[1][0] = 0;

        for (int i = 1; i < N; i++) {
            for (int used = 0; used < 2; used++) {
                if (dp[i][used] == INF) continue;

                if (i + 1 <= N) dp[i + 1][used] = Math.min(dp[i + 1][used], dp[i][used] + small[i]);

                if (i + 2 <= N) dp[i + 2][used] = Math.min(dp[i + 2][used], dp[i][used] + big[i]);

                if (used == 0 && i + 3 <= N) dp[i + 3][1] = Math.min(dp[i + 3][1], dp[i][0] + K);

            }
        }

        int ans = Math.min(dp[N][0], dp[N][1]);
        System.out.println(ans);
    }
}
