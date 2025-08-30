import java.util.*;
import java.io.*;

public class Main {
    static String S;
    static int ans = Integer.MAX_VALUE, X,L;
    static boolean[] visit;

    static void f(int k, int sum){
        if (k==L){
            if (X<sum) ans = Math.min(ans, sum);
            return;
        }
        for (int i=0;i<L;i++){
            if (visit[i]) continue;
            visit[i] = true;
            f(k+1, sum*10+(S.charAt(i)-'0'));
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        S = br.readLine();
        L =S.length();
        X = Integer.parseInt(S);
        visit = new boolean[L];

        f(0,0);
        if (ans == Integer.MAX_VALUE) ans = 0;
        System.out.println(ans);
    }
}