import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int tc = 0;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            tc++;
            int[][] dp = new int[N][3];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) dp[i][j] = Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<N; i++) {
                if(i==1) {
                    for(int j=0; j<3; j++) {
                        if(j==0) dp[i][0] += dp[i-1][1];
                        else {
                            dp[i][j] += Math.min(dp[i][j-1],
                                    Math.min(dp[i-1][1], dp[i-1][1]+dp[i-1][2]));
                        }
                    }
                }else {
                    dp[i][0] += Math.min(dp[i-1][0], dp[i-1][1]);
                    dp[i][1] += Math.min(Math.min(dp[i][0], dp[i-1][0]),
                            Math.min(dp[i-1][1], dp[i-1][2]));
                    dp[i][2] += Math.min(dp[i][1],Math.min(dp[i-1][1], dp[i-1][2]));
                }
            }
            ans.append(tc).append(". ").append(dp[N-1][1]).append("\n");
        }
        System.out.println(ans);
    }


}