import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken()), ans = 0;
        int[][] arr = new int[N][M], dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s[j] - '0';
                dp[i][j] = arr[i][j];
                if (ans ==0 && dp[i][j]==1) ans = 1;
                if (i==0 || j==0) continue;
                if (dp[i-1][j-1]>0 && dp[i-1][j]>0 && dp[i][j-1]>0 && arr[i][j]>0) {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.print(ans*ans);
    }


}
