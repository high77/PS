import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()), G = Integer.parseInt(st.nextToken());

        int commonDivisor = gcd(R, G);

        StringBuilder ans = new StringBuilder();
        for (int i = 1; i * i <= commonDivisor; i++) {
            if (commonDivisor % i == 0) {
                ans.append(i).append(" ").append(R / i).append(" ").append(G / i).append("\n");

                if (i * i != commonDivisor) {
                    int other = commonDivisor / i;
                    ans.append(other).append(" ").append(R / other).append(" ").append(G / other).append("\n");
                }
            }
        }
        System.out.println(ans);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}