import java.io.*;
import java.util.*;

public class Main {
    static boolean result(int a, String calc, int b) {
        switch (calc) {
            case ">":   return a>b;
            case ">=":  return a>=b;
            case "<":   return a<b;
            case "<=":  return a<=b;
            case "==":  return a==b;
            case "!=":  return a!=b;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T=1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String calc = st.nextToken();
            if (calc.equals("E")) break;
            int b = Integer.parseInt(st.nextToken());
            ans.append(String.format("Case %d: %s\n", T++, result(a, calc, b)?"true":"false"));
        }
        System.out.println(ans);
    }
}