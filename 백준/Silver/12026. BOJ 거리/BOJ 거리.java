import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char getNext(char c){
        if (c == 'B') return 'O';
        if (c == 'O') return 'J';
        return 'B';
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();
        int[] dp = new int[N];
        final int INF = 1000001;
        Arrays.fill(dp,INF);
        dp[0] =0;
        for (int i = 0; i < N; i++) {
            if (dp[i]==INF) continue;
            char next = getNext(S[i]);
            for (int j = i+1; j < N; j++) {
                if (next==S[j]) dp[j] = Math.min(dp[j],dp[i]+(j-i)*(j-i));
            }
        }
        if (dp[N-1]==INF) dp[N-1] = -1;
        System.out.println(dp[N-1]);
    }
}