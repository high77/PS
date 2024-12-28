import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken())
                , K = Integer.parseInt(st.nextToken())
                , C = Integer.parseInt(st.nextToken());
        int[] belt = new int[N];
        int[] check = new int[M+1];
        for (int i = 0; i < N; i++) belt[i] = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            if (check[belt[i]] == 0) cnt++;
            check[belt[i]]++;
        }
        if (check[C]==0) cnt++;
        check[C]++;
        ans = cnt;
        for (int i = 1; i < N; i++) {
            int s = belt[i-1], e = belt[(K-1+i)%N];
            check[s]--;
            if (check[s]==0) cnt--;
            if (check[e]==0) cnt++;
            check[e]++;
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }

}
