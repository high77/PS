import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N,K,L;
    static int[] res = new int[11];

    static void f(int k,int s){
        if (s==N){
            K--;
            L=k;
            return;
        }
        for (int i=1;i<4;i++){
            if (s+i>N || K==0) break;
            res[k] = i;
            f(k+1,s+i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        f(0,0);

        if (K!=0) ans.append(-1);
        else {
            for (int i=0;i<L;i++){
                if (i!=0) ans.append("+");
                ans.append(res[i]);
            }
        }
        System.out.println(ans);
    }
}