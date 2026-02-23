import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();

        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            int sum = getDivisorSum(n);

            if (sum == n) ans.append("Perfect\n");
            else if (sum < n) ans.append("Deficient\n");
            else ans.append("Abundant\n");
        }
        System.out.print(ans);
    }

    static int getDivisorSum(int n) {
        if (n == 1) return 0;

        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i * i != n) sum += n / i;
            }
        }
        return sum;
    }
}