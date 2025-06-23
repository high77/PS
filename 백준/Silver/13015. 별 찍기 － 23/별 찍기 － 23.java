import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int i, j;

        for (i = 1; i <= 2 * n - 1; i++) {
            if (i == 1 || i == (n + (n - 1))) { // 첫 줄과 마지막 줄
                for (j = 1; j <= n; j++) ans.append("*");
                for (j = 1; j <= (n - 1) + (n - 2); j++) ans.append(" ");
                for (j = 1; j <= n; j++) ans.append("*");
            } else {
                if (i < n) {
                    for (j = 1; j <= i - 1; j++) ans.append(" ");
                    ans.append("*");
                    for (j = 1; j <= n - 2; j++) ans.append(" ");
                    ans.append("*");
                    for (j = 1; j <= (n - 1) + (n - 2) - 2 * (i - 1); j++) ans.append(" ");
                    ans.append("*");
                    for (j = 1; j <= n - 2; j++) ans.append(" ");
                    ans.append("*");
                } else if (i > n) {
                    for (j = 1; j <= n - (i % n) - 1; j++) ans.append(" ");
                    ans.append("*");
                    for (j = 1; j <= n - 2; j++) ans.append(" ");
                    ans.append("*");
                    for (j = 1; j <= 2 * (i % n) - 1; j++) ans.append(" ");
                    ans.append("*");
                    for (j = 1; j <= n - 2; j++) ans.append(" ");
                    ans.append("*");
                } else {
                    for (j = 1; j <= i - 1; j++) ans.append(" ");
                    ans.append("*");
                    for (j = 1; j <= n - 2; j++) ans.append(" ");
                    ans.append("*");
                    for (j = 1; j <= n - 2; j++) ans.append(" ");
                    ans.append("*");
                }
            }
            ans.append("\n");
        }

        System.out.print(ans);
    }
}
