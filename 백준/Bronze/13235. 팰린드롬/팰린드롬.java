import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int L = S.length();
        boolean ans = true;
        for (int i=0; i < L / 2; i++) {
            if (S.charAt(i) != S.charAt(L - 1 - i)) {
                ans = false;
                break;
            }
        }

        System.out.println(ans);
    }
}
