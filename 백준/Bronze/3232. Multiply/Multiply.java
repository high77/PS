import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            String pStr = input[0], qStr = input[1], rStr = input[2];

            int minBase = Math.max(Math.max(getMinBase(pStr), getMinBase(qStr)), getMinBase(rStr));

            int resultBase = 0;

            for (int base = Math.max(minBase, 2); base <= 16; base++) {
                long p = toDecimal(pStr, base);
                long q = toDecimal(qStr, base);
                long r = toDecimal(rStr, base);

                if (p >= 0 && q >= 0 && r >= 0 && p * q == r) {
                    resultBase = base;
                    break; 
                }
            }

            sb.append(resultBase).append("\n");
        }

        System.out.print(sb);
    }

    private static int getMinBase(String num) {
        int maxDigit = 0;
        for (char c : num.toCharArray()) {
            maxDigit = Math.max(maxDigit, c - '0');
        }
        return maxDigit + 1;
    }

    private static long toDecimal(String num, int base) {
        long result = 0;
        for (char c : num.toCharArray()) {
            result = result * base + (c - '0');

            if (result > 1_000_000_000_000L) {
                return -1;
            }
        }
        return result;
    }
}
