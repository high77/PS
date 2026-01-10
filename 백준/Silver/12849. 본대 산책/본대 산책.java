import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int d =Integer.parseInt(br.readLine());
        int mod = 1000000007;
        long[] dp = new long[8];
        dp[0] = 1;

        for(int i=0; i<d; i++) {
            long[] temp = new long[8];

            temp[0] = (dp[1] + dp[3]) % mod;
            temp[1] = (dp[0] + dp[2] + dp[3]) % mod;
            temp[2] = (dp[1] + dp[3] + dp[4] + dp[5]) % mod;
            temp[3] = (dp[0] + dp[1] + dp[2] + dp[5]) % mod;
            temp[4] = (dp[2] + dp[5] + dp[6]) % mod;
            temp[5] = (dp[2] + dp[3] + dp[4] + dp[7]) % mod;
            temp[6] = (dp[4] + dp[7]) % mod;
            temp[7] = (dp[5] + dp[6]) % mod;

            dp = temp;
        }
        System.out.println(dp[0]);
    }
}