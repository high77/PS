import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken())
                , N = Integer.parseInt(st.nextToken());
        int[] coins = new int[V];
        long[] dp = new long[N+1];
        dp[0] = 1;
        for (int i = 0; i < V; i++) coins[i]= Integer.parseInt(br.readLine());
        for (int coin:coins) {
            for (int j = coin; j <= N; j++) dp[j]+=dp[j-coin]!=0?dp[j-coin]:0;
        }
        System.out.println(dp[N]);

    }
}
