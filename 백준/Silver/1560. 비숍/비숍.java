import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        BigInteger N = new BigInteger(br.readLine());
        if (N.equals(new BigInteger("1"))) ans.append(1);
        else ans.append(N.multiply(BigInteger.valueOf(2)).subtract(BigInteger.valueOf(2)));
        System.out.println(ans);
    }
}
