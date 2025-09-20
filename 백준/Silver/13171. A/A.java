import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    static long pow(long a, long x, long ans) {
        if (x == 0) return ans;

        if ((x & 1) == 1) ans = ans * a % MOD;

        return pow((a * a) % MOD, x >> 1, ans);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long A = Long.parseLong(br.readLine()), X = Long.parseLong(br.readLine());

        A %= MOD;
        long ans = pow(A, X, 1);

        System.out.println(ans);
    }
}
