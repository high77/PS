import java.io.*;
import java.util.*;

public class Main {

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken())
                , P1 = Integer.parseInt(st.nextToken()), P2 = Integer.parseInt(st.nextToken());
        if (Math.abs(P1 - P2) % gcd(X, Y) != 0) {
            System.out.println(-1);
            return;
        }

        while (P1 != P2) {
            if (P2 > P1) P1 += X;
            else P2 += Y;
            if (P1 > 1_000_000_000 || P2 > 1_000_000_000) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(P1);
    }
}