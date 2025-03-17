import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        long[][] dp = new long[65][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i < 65; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) dp[i][j] += dp[i - 1][k];
            }
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            long res =0;
            for (int i = 0; i < 10; i++) res+=dp[N][i];
            ans.append(res+"\n");
        }
        System.out.println(ans);
    }


}
