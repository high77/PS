import java.io.*;
import java.util.*;

public class Main {

    static long[][] dp;

    static long dfs(int n, int m) {
        if (n==0 || m==0) return 0;
        if (n==1 || m==1) return 1;
        if (dp[n][m] != -1) return dp[n][m];
        dp[n][m] = (dfs(n,m-1)+dfs(n-1,m)+dfs(n-1,m-1))%1000000007;
        return dp[n][m];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken());
        dp = new long[N + 1][M + 1];
        for (int i = 0; i <= N; i++) Arrays.fill(dp[i], -1);
        System.out.println(dfs(N,M));

    }
}
