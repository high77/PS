import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        char before = '0';
        char after = '0';
        boolean flag_b = false;
        boolean flag_a = false;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (!s.equals("?")) {
                set.add(s);
                if (flag_b && !flag_a) {
                    after = s.charAt(0);
                    flag_a = true;
                }
            } else  flag_b = true;

            if (!flag_b) before = s.charAt(s.length() - 1);
        }

        String result = "";

        int m = Integer.parseInt(br.readLine());
        if (n == 1) ans.append(br.readLine());
        else {
            for (int i = 0; i < m; i++) {
                String s = br.readLine();
                if ((s.charAt(0) == before || before == '0') && (s.charAt(s.length() - 1) == after || after == '0') && !set.contains(s)) result = s;
            }
            ans.append(result);
        }
        System.out.println(ans);
    }
}