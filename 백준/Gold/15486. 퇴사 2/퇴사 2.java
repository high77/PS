import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine()), ans = -1;
        int[][] reservation = new int[N+2][2];
        int[] dp = new int[N+2];
        for (int i = 1; i <=N+1; i++) {
            if (i<N+1){
                String[] input = br.readLine().split(" ");
                for (int j=0; j<2; j++) reservation[i][j] = Integer.parseInt(input[j]);
            }
            if (ans<dp[i]) ans = dp[i];
            int next = i+reservation[i][0];
            if (next>N+1) continue;
            dp[next] =Math.max(dp[next], ans+reservation[i][1]);
        }
        System.out.println(dp[N+1]);
    }
}
