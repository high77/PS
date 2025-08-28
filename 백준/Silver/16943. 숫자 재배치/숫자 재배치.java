import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main {

    static int[] A ;
    static int B ,L, ans =-1;
    static boolean[] visit;

    static void f(int k,int sum){

        if (k==L) {
            if (B<sum) return;
            ans = Math.max(ans,sum);
            return;
        }

        for (int i = 0; i < L; i++) {
            if (visit[i] || (k==0 && A[i]==0)) continue;
            visit[i] = true;
            f(k+1,sum*10+A[i]);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] tmp = st.nextToken().toCharArray();
        L = tmp.length;
        A = new int[L];
        for (int i = 0; i < L; i++) A[i] = tmp[i] - '0';
        visit = new boolean[L];
        B = Integer.parseInt(st.nextToken());

        f(0,0);
        System.out.println(ans);
    }
}