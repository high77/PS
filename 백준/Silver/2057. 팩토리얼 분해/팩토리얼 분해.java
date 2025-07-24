import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        
        BigInteger N = new BigInteger(br.readLine());
        BigInteger n = new BigInteger("1");
        Stack<BigInteger> stack = new Stack<>();
        int i = 1;
        while (n.compareTo(N) <= 0) {
            stack.push(n);
            n=n.multiply(BigInteger.valueOf(i++));
        }
        while (!stack.isEmpty()) {
            BigInteger tmp = stack.pop();
            if (tmp.compareTo(N) <= 0) N=N.subtract(tmp);
        }
        System.out.println(N != BigInteger.valueOf(0) ? "NO" : "YES");
    
    }
}