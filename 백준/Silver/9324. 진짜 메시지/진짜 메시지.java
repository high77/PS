import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] cnts;
        for (int tc = 1; tc <= T; tc++) {
            cnts  = new int[26];
            char[] S = br.readLine().toCharArray();
            boolean check = false, flag = true;
            for (char c : S) {
                int i = c - 'A';
                if (check) {
                    if (cnts[i] != 3) {
                        flag = false;
                        break;
                    }
                    cnts[i] = 0;
                    check = false;
                } else {
                    cnts[i]++;
                    if (cnts[i] == 3) check = true;
                }
            }

            for (int cnt:cnts ) {
                if (cnt == 3) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans.append("OK");
            else ans.append("FAKE");
            ans.append("\n");
        }
        System.out.println(ans);
    }
}

