import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken());
        int[][] space = new int[N][M];
        int[][][] dp = new int[N][M][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (i==0) Arrays.fill(dp[i][j], space[i][j]);
                else Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j!=0) dp[i][j][0] = Math.min(dp[i-1][j-1][1],dp[i-1][j-1][2])+space[i][j];
                dp[i][j][1] = Math.min(dp[i-1][j][0],dp[i-1][j][2]) + space[i][j];
                if (j!=M-1) dp[i][j][2] = Math.min(dp[i-1][j+1][0],dp[i-1][j+1][1])+space[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++)ans = Math.min(ans, dp[N-1][i][j]);
        }
        System.out.println(ans);

    }
}
