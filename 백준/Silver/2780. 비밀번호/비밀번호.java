import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[1001][10];
        int[][] adj = {{7}, {2,4}, {1,3,5}, {2,6}, {1,5,7}, {2,4,6,8}, {3,5,9}, {0,4,8}, {5,7,9}, {6,8}};
        long[] res = new long[1001];

        Arrays.fill(dp[1], 1);
        res[1] = 10;

        for (int i = 2; i <= 1000; i++) {
            for (int j = 0; j < 10; j++) {
                for (int neighbor : adj[j]) dp[i][j] = (dp[i][j] + dp[i-1][neighbor]) % 1234567;
                res[i] = (res[i] + dp[i][j]) % 1234567;
            }
        }

        StringBuilder ans = new StringBuilder();
        while (T-- > 0) {
            ans.append(res[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(ans);
    }
}