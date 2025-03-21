import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pay = Integer.parseInt(st.nextToken())
                , year = Integer.parseInt(st.nextToken());
        long[] dp = new long[year+1];
        dp[0] = pay;
        for (int i = 1; i <= year; i++) {
            dp[i] = (long) Math.floor(dp[i-1]*1.05);
            if (i>=3) dp[i] = Math.max((long)Math.floor(dp[i-3]*1.2),dp[i]);
            if (i>=5) dp[i] = Math.max((long)Math.floor(dp[i-5]*1.35),dp[i]);
        }
        System.out.println(dp[year]);
    }
}
