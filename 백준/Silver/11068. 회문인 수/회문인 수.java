import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static boolean isPalindromeInAnyBase(int N) {
        for (int base = 2; base <= 64; base++) {
            if (isPalindromeInBase(N, base)) return true;
        }
        return false;
    }

    private static boolean isPalindromeInBase(int N, int base) {
        int[] digits = new int[64];
        int len = 0;

        while (N > 0) {
            digits[len++] = N % base;
            N /= base;
        }

        for (int i = 0; i < len / 2; i++) {
            if (digits[i] != digits[len - 1 - i]) return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        while (T-- > 0) ans.append(isPalindromeInAnyBase(Integer.parseInt(br.readLine())) ? 1 : 0).append("\n");

        System.out.print(ans);
    }

    
}
