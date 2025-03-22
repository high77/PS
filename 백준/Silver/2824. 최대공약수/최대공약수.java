import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger A = BigInteger.ONE, B = BigInteger.ONE;
        for (int i = 0; i < n; i++) A = A.multiply(new BigInteger(st.nextToken()));
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) B = B.multiply(new BigInteger(st.nextToken()));
        String res = A.gcd(B).toString();
        ans.append(res.length()>9?res.substring(res.length()-9,res.length()):res);
        System.out.println(ans);
    }
}
