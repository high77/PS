import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static final int[] SMALL = {1, 1, 2, 6, 4};
    static final int[] POW2 = {6, 2, 4, 8};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            ans.append(lastNonZeroDigit(n)).append('\n');
        }
        System.out.print(ans);
    }

    static int lastNonZeroDigit(int n) {
        if (n < 5) return SMALL[n];

        int q = n / 5;
        int r = n % 5;

        int result = lastNonZeroDigit(q);
        result = (result * SMALL[r]) % 10;
        result = (result * POW2[q % 4]) % 10;

        return result;
    }
}
