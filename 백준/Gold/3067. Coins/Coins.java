import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];
            for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M+1];
            for (int i=0;i<N;i++) {
                if (coins[i]>M) continue;
                dp[coins[i]]++;
                for (int j=coins[i]+1;j<=M;j++) {
                    dp[j] += dp[j-coins[i]];
                }
            }
            ans.append(dp[M]).append("\n");
        }
        System.out.println(ans);
    }
}
