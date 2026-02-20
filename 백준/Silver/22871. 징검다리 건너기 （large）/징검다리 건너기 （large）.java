import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N + 1];
        long[] dp = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) A[i] = Long.parseLong(st.nextToken());

        Arrays.fill(dp, -1);
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                long power = (i - j) * (1 + Math.abs(A[i] - A[j]));
                long currentK = Math.max(dp[j], power);
                
                if (dp[i] == -1 || dp[i] > currentK) dp[i] = currentK;
            }
        }
        System.out.println(dp[N]);
    }
}