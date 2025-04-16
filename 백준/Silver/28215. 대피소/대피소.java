import java.io.*;
import java.util.*;
public class Main{
    static int N,K,list[], ans =Integer.MAX_VALUE, location[][],min[];

    static void f(int k,int i) {
        if (k == K) {
            int res = 0;
            min = new int[N];
            Arrays.fill(min, Integer.MAX_VALUE);
            for (int shelter:list){
                int a = location[shelter][0], b = location[shelter][1];
                for (int j=0;j<N;j++){
                    int x = Math.abs(a-location[j][0]), y = Math.abs(b-location[j][1]);
                    min[j] = Math.min(min[j], x+y);
                }
            }
            for (int n:min) res = Math.max(res,n);
            ans = Math.min(ans,res);
            return;
        }
        for (int j = i+1; j < N; j++) {
            list[k] = j;
            f(k+1,j);
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[K];
        location = new int[N][2] ;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            location[i][0] = Integer.parseInt(st.nextToken());
            location[i][1] = Integer.parseInt(st.nextToken());
        }
        f(0,-1);
        System.out.println(ans);
    }
}