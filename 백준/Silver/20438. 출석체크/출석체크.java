import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(st.nextToken())
                , K = Integer.parseInt(st.nextToken())
                , Q = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken());

        boolean[] sleep = new boolean[N+3],check = new boolean[N+3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) sleep[Integer.parseInt(st.nextToken())] = true;
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<Q;i++) {
            int q = Integer.parseInt(st.nextToken());
            if (sleep[q]) continue;
            for (int j=q;j<N+3;j+=q) {
                if (sleep[j]) continue;
                check[j] = true;
            }
        }
        int[] cnt = new int[N+3];
        for (int i=3;i<N+3;i++) {
            cnt[i] = cnt[i-1];
            cnt[i] += check[i] ? 0 : 1;
        }
        for (int i=0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            ans.append(cnt[e]-cnt[s-1]).append("\n");
        }

        System.out.println(ans);
    }
}