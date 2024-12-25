import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int R = 0, A = 0;

            while (true) {
                String input = br.readLine();
                if (input.isEmpty()) break;
                A += input.length();
                R += input.replaceAll("#", "").length();
            }

            double res = (double) R / A * 100;
            res = Math.round(res * 10) / 10.0;

            if (res == (int) res) ans.append(String.format("Efficiency ratio is %d%%.%n", (int) res));
            else ans.append(String.format("Efficiency ratio is %.1f%%.%n", res));
        }
        System.out.print(ans);
    }
}
