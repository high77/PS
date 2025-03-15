import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N+1];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())
                    , b = Integer.parseInt(st.nextToken());
            list[i] = a;
            list[i+1] = b;
        }
        for (int i=2; i<=N; i++) {
            for (int j=0; j<=N-i; j++) {
                dp[j][j+i-1] = Integer.MAX_VALUE;
                for (int k=j;k<j+i-1;k++){
                    int tmp = dp[j][k] + dp[k+1][j+i-1]+ (list[j]*list[k+1]*list[i+j]);
                    dp[j][j+i-1] = Math.min(dp[j][j+i-1], tmp);
                }
            }
        }
        System.out.print(dp[0][N-1]);
    }


}
