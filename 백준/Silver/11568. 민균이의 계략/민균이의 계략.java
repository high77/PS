import java.io.*;
        import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine()),ans = 1;
        int[] list = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp,1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (list[i] > list[j]) dp[i] = Math.max(dp[j]+1, dp[i]);
            }
            ans = Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }
}