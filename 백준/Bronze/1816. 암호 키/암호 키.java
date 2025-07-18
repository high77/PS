import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            long n = Long.parseLong(br.readLine());
            for (int j = 2; j <1000001; j++) {
                if (n % j == 0) {
                    ans.append("NO");
                    break;
                }
                if (j==1000000) ans.append("YES");
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}