import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int i, j;

        for (i = 1; i <= 2 * n - 1; i++) {
            if (i == 1 || i == (n + (n - 1))) { // 첫 줄과 마지막 줄
                for (j = 1; j <= n; j++) sb.append("*");
                for (j = 1; j <= (n - 1) + (n - 2); j++) sb.append(" ");
                for (j = 1; j <= n; j++) sb.append("*");
            } else {
                if (i < n) {
                    for (j = 1; j <= i - 1; j++) sb.append(" ");
                    sb.append("*");
                    for (j = 1; j <= n - 2; j++) sb.append(" ");
                    sb.append("*");
                    for (j = 1; j <= (n - 1) + (n - 2) - 2 * (i - 1); j++) sb.append(" ");
                    sb.append("*");
                    for (j = 1; j <= n - 2; j++) sb.append(" ");
                    sb.append("*");
                } else if (i > n) {
                    for (j = 1; j <= n - (i % n) - 1; j++) sb.append(" ");
                    sb.append("*");
                    for (j = 1; j <= n - 2; j++) sb.append(" ");
                    sb.append("*");
                    for (j = 1; j <= 2 * (i % n) - 1; j++) sb.append(" ");
                    sb.append("*");
                    for (j = 1; j <= n - 2; j++) sb.append(" ");
                    sb.append("*");
                } else { 
                    for (j = 1; j <= i - 1; j++) sb.append(" ");
                    sb.append("*");
                    for (j = 1; j <= n - 2; j++) sb.append(" ");
                    sb.append("*");
                    for (j = 1; j <= n - 2; j++) sb.append(" ");
                    sb.append("*");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
