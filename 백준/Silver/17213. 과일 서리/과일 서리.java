import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine()),M = Integer.parseInt(br.readLine());
        int[][] dp = new int[11][31];
        Arrays.fill(dp[1],1);
        dp[1][0] = 0;
        for (int i = 1; i <= N; i++) dp[i][i]=1;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= M; j++) dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
        }

        System.out.println(dp[N][M]);
    }
}