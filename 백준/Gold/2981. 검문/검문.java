import java.io.*;
import java.util.*;

public class Main {

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++)list[i]= Integer.parseInt(br.readLine());
        Arrays.sort(list);

        int res = list[1]-list[0];
        for (int i=2; i<N; i++) res = gcd(res,list[i]-list[i-1]);
        for (int i = 2; i <= res; i++) {
            if (res%i == 0) ans.append(i).append(" ");
        }
        System.out.println(ans);
    }
}