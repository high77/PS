import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        BigInteger[] fibo = new BigInteger[10001];
        fibo[0] = new BigInteger("0");
        fibo[1] = new BigInteger("1");
        for (int i = 2; i <= 10000; i++) fibo[i] = fibo[i-1].add(fibo[i-2]);
        StringTokenizer st ;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
            ans.append("Case #").append(tc).append(": ").append(fibo[P].remainder(BigInteger.valueOf(Q))).append("\n");
        }

        System.out.println(ans);
    }
}