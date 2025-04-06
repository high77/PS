import java.io.*;
import java.util.*;

public class Main {

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static String f(String s, int lcm){
        String res = s;
        while (res.length()<lcm) res+=s;
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String s = br.readLine(), t = br.readLine();
        int lcm = (s.length()*t.length())/gcd(s.length(), t.length());
        String a = f(s, lcm),b = f(t, lcm);
        if (a.equals(b)) ans.append(1);
        else ans.append(0);
        System.out.println(ans);

    }
}