import java.util.*;
import java.io.*;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), T  = Integer.parseInt(st.nextToken());
        int n = Math.min(N, M), m = Math.max(N,M);
        int burger = T/n, coke = T%n ;
        if (coke != 0){
            for (int i=1; i<=T/m; i++){
                if ((T-(i*m))%n>=coke) continue;
                burger = i+(T-(i*m))/n;
                coke= (T-(i*m))%n;
            }
        }
        ans.append(burger+" "+coke);
        System.out.println(ans);
    }
}