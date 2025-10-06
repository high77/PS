import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final long MOD = 1_000_000_007L;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long ans = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long C = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            if (K > 0) { // 미분 가능 항만 계산
                long val = (C * K) % MOD;
                long pow = 1;
                long base = 2;

                long exp = K - 1;
                while (exp > 0) {
                    if ((exp & 1) == 1) pow = (pow * base) % MOD;
                    base = (base * base) % MOD;
                    exp >>= 1;
                }

                ans = (ans + val * pow) % MOD;
            }
        }

        System.out.println(ans);
    }
}
