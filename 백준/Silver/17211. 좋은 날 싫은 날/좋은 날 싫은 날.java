import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken()), b = Double.parseDouble(st.nextToken())
                , c = Double.parseDouble(st.nextToken()), d = Double.parseDouble(st.nextToken());
        double[][] dp = new double[N + 1][2];
        if (k==0) {
            dp[1][0] = a;
            dp[1][1] = b;
        }else {
            dp[1][0] = c;
            dp[1][1] = d;
        }
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0]*a + dp[i-1][1]*c;
            dp[i][1] = dp[i-1][0]*b + dp[i-1][1]*d;
        }
        ans.append(Math.round(dp[N][0]*1000)).append("\n");
        ans.append(Math.round(dp[N][1]*1000)).append("\n");
        System.out.println(ans);
    }
}