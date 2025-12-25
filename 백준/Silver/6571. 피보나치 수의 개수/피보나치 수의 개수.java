import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static List<BigInteger> fib = new ArrayList<>();

    static void initFib() {
        // f1 = 1, f2 = 2
        fib.add(BigInteger.ONE);
        fib.add(BigInteger.TWO);

        BigInteger limit = BigInteger.TEN.pow(100);

        while (true) {
            int size = fib.size();
            BigInteger next = fib.get(size - 1).add(fib.get(size - 2));
            if (next.compareTo(limit) > 0) break;
            fib.add(next);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        initFib();

        String line;
        while (true) {
            line = br.readLine();
            if (line == null) break;

            st = new StringTokenizer(line);
            String aStr = st.nextToken();
            String bStr = st.nextToken();

            if (aStr.equals("0") && bStr.equals("0")) break;

            BigInteger a = new BigInteger(aStr);
            BigInteger b = new BigInteger(bStr);

            int cnt = 0;
            for (BigInteger f : fib) {
                if (f.compareTo(a) >= 0 && f.compareTo(b) <= 0) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
