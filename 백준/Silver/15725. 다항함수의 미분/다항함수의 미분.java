import java.io.*;
import java.util.*;

public class Main {
    static int mod = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int res = 10001;

        if (s.charAt(0)=='x') res = 1;
        else if (s.charAt(0)=='-' && s.charAt(1)=='x') res = -1;
        else if (s.indexOf('x') == -1) res = 0;
        

        if (res != 10001) {
            System.out.println(res);
            return;
        }

        int x = s.indexOf('x');
        String ans = "";
        for (int i = x-1; i >= 0; i--) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                ans = s.charAt(i) + ans;
                break;
            }
            ans = s.charAt(i) + ans;
        }
        System.out.println(ans);
    }

}