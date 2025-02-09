import java.io.*;
import java.util.*;

public class Main {
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    static long lcm(long a, long b,long gcd) {
        return a * b / gcd;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        long res1 = a, res2 = b, time =1;
        long ans1 = res1, ans2 = res2, min = ans1+ans2;
        while (res1<res2){
            time++;
            if (b%time!=0) continue;
            res1 = a*time;
            res2 = b/time;
            long gcd = gcd(res1, res2);
            if (gcd != a) continue;
            long lcm = lcm(res1, res2, gcd);
            if (lcm == b && min>res1+res2) {
                ans1 =res1;
                ans2=res2;
                min=res1+res2;
            }
        }
        ans.append(ans1+" "+ans2);
        System.out.print(ans);
    }
}
