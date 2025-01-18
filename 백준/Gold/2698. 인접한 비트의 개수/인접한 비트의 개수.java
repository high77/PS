import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
            int[][][] dp = new int[N + 1][K+1][2];
            dp[1][0][0] = dp[1][0][1] = 1;
            for (int i=2; i<=N; i++) {
                for (int j=0; j<=K; j++) {
                    if (i<=j) break;
                    dp[i][j][0] =  dp[i-1][j][0]+dp[i-1][j][1];
                    dp[i][j][1] =  dp[i-1][j][0];
                    if (j!=0) dp[i][j][1] += dp[i-1][j-1][1];
                }
            }
            ans.append(dp[N][K][0]+dp[N][K][1]).append("\n");
        }
        System.out.print(ans);
    }
}
