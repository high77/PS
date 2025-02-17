import java.io.*;
import java.util.*;

public class Main {
    static class Chapter {
        int day,page;
        public Chapter(int day, int page){
            this.day=day;
            this.page=page;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),M = Integer.parseInt(st.nextToken());
        Chapter[] chapters = new Chapter[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            chapters[i] = new Chapter(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        int[] dp = new int[N+1];
        for (Chapter c : chapters) {
            for (int i = N; i >=c.day; i--) {
                if (i!=c.day) {
                    if (dp[i-c.day]!=0) dp[i] = Math.max(dp[i],dp[i-c.day]+c.page);
                }
                else dp[i] = Math.max(dp[i],dp[i-c.day]+c.page);
            }
        }
        int res = 0;
        for (int i = 1; i <= N; i++) res = Math.max(res,dp[i]);
        ans.append(res);
        System.out.println(ans);
    }
}
