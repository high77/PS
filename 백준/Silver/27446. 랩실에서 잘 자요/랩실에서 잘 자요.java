import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans= 0;
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        boolean[] check = new boolean[N+1];
        for (int i = 0; i < M; i++) check[Integer.parseInt(st.nextToken())]= true;
        int last = -1;
        for (int i=1; i<=N; i++) {
            if (check[i]) continue;
            if (last ==-1)ans +=7;
            else{
                int gap = i-last;
                ans += Math.min(gap*2,7);
            }
            last = i;
        }
        System.out.println(ans);
    }
}