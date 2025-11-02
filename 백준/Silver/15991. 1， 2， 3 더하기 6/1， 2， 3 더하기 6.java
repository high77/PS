import java.io.*;
import java.util.*;

public class Main {
    static int mod = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[100001];
        dp[0] = dp[1] = 1;
        dp[2] = dp[3] = 2;
        for (int i = 4; i < 100001; i++) dp[i] = (dp[i-2]+dp[i-4]+(i>=6?dp[i-6]:0))%mod;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            ans.append(dp[N]).append("\n");
        }
        System.out.print(ans);
    }

}