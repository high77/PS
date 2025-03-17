import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        BigInteger[] dp = new BigInteger[251];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");
        for (int i = 3; i <= 250; i++) dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
        String s ;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            System.out.println(dp[n]);
        }
//        System.out.println(ans);
    }


}
