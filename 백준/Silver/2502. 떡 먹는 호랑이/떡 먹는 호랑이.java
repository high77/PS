import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder ans = new StringBuilder();
        int D = Integer.parseInt(st.nextToken())
                , K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[D+1][2];
        dp[1][0]= dp[2][1] = 1;
        for (int i = 3; i <= D; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j]=dp[i-1][j]+dp[i-2][j];
            }
        }
        int a=1;
        while (true) {
            if ((K-(dp[D][0]*a))%dp[D][1]==0) {
                ans.append(a+"\n");
                ans.append((K-(dp[D][0]*a))/dp[D][1]);
                break;
            }
            a++;
        }
        System.out.println(ans);
    }
}
