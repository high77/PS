import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[51];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= N; i++) dp[i] = (1+dp[i-1]+dp[i-2])%1000000007;
        System.out.println(dp[N]);
    }
}