import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        int[] dp = new int[N];
        int max,min;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int j = i; j >=0 ; j--) {
                max = Math.max(max, list[j]);
                min = Math.min(min, list[j]);
                dp[i] = Math.max(dp[i],max-min+(j>0?dp[j-1]:0));
            }
        }
        System.out.println(dp[N-1]);
    }
}
