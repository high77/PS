import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();

        while (T-- > 0) {
            long N = Long.parseLong(st.nextToken());
            long res = sum(N, 3) + sum(N, 7) - sum(N, 21);
            ans.append(res).append("\n");
        }

        System.out.print(ans);
    }

    static long sum(long N, int k) {
        long m = N / k;
        return k * m * (m + 1) / 2;
    }
}
