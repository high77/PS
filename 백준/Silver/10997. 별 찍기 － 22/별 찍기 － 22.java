import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int idx =1;
        for (int i = 1; i <= N; i++) {
            if (N == 1) {
                ans.append("*");
                break;
            }
            ans.append("* ".repeat(i - 1));
            if (i == 1) {
                ans.append("*".repeat((N * 4) - (i * 4 - 1)));
            } else if (i < 3) {
                ans.append("*".repeat((N * 4) - (i * 4 - 3)));
            } else {
                ans.append("*".repeat((N * 4) - (i * 4 - 3))+ " *".repeat(idx));
                idx++;
            }
            ans.append("\n");

            if (i == 1) {
                ans.append("*");
            } else if (i == N) {
                ans.append("*" + " *".repeat(N * 2 - 2));
            } else {
                ans.append("* ".repeat(i) + " ".repeat((N - i) * 4 - 1) + " *".repeat(i-1));
            }
            ans.append("\n");
        }

        if (N != 1) ans.append("*" + " *".repeat(N * 2 - 2)+"\n");

        for (int i = N - 1; i >= 1; i--) {
            ans.append("* ".repeat(i) + " ".repeat((N - i) * 4 - 3) + " *".repeat(i)+"\n");
            ans.append("* ".repeat(i - 1) + "*".repeat((N - i) * 4 + 1) + " *".repeat(i - 1)+"\n");
        }
        System.out.println(ans);
    }

}