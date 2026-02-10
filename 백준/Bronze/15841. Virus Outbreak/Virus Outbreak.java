import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        BigInteger[] dp = new BigInteger[491];
        dp[0] = new BigInteger("0");
        dp[1]= new BigInteger("1");
        for (int i = 2; i < 491; i++) dp[i] = dp[i-1].add(dp[i-2]);
        while (true){
            int N = Integer.parseInt(br.readLine());
            if (N == -1) break;
            ans.append("Hour ").append(N).append(": ").append(dp[N]).append(" cow(s) affected").append("\n");
        }
        System.out.println(ans);
    }
}