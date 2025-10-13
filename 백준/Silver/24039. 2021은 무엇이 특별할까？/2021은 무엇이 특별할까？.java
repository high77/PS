import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] notPrime = new boolean[11000];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i * i < notPrime.length; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < notPrime.length; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) primes.add(i);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < primes.size() - 1; i++) {
            int val = primes.get(i) * primes.get(i + 1);
            if (val > N) {
                res = val;
                break;
            }
        }

        System.out.println(res);
    }
}
