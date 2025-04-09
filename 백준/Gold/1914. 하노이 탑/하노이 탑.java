import java.io.*;
import java.math.BigInteger;

public class Main {
    static StringBuilder ans = new StringBuilder();

    static void hanoi(int n, int s, int e){
        if (n == 0) return;
        hanoi(n-1, s, 6 - s - e);
        ans.append(s+" "+e+"\n");
        hanoi(n-1, 6 - s - e, e);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger n = new BigInteger("2");
        ans.append(n.pow(N).subtract(BigInteger.ONE));
        if (N<21) {
            ans.append("\n");
            hanoi(N,1,3);
        }
        System.out.println(ans);
    }
}