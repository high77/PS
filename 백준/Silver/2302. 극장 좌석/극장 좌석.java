import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine())
                , M = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= N; i++) dp[i] = dp[i-1]+ dp[i-2];
        int tmp = 0, ans = 1;
        for (int i=0;i<M;i++) {
            int now = Integer.parseInt(br.readLine());
            ans *= dp[now- tmp-1];
            tmp = now;
        }
        ans *= dp[N-tmp];
        System.out.println(ans);
    }
}
