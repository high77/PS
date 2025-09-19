import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] view = new boolean[2001][2001];

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D1 = Integer.parseInt(st.nextToken()), D2 = Integer.parseInt(st.nextToken());

        long ans = 0;

        for (int i = D1; i <= D2; i++) {
            for (int j = 1; j <= i; j++) {
                int g = gcd(i, j);
                int x = i / g, y = j / g;
                if (view[x][y]) continue;
                view[x][y] = true;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
