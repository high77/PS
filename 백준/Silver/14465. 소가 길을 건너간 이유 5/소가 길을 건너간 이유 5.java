import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken())
                , B = Integer.parseInt(st.nextToken());

        boolean[] list = new boolean[N + 1];
        for (int i = 0; i < B; i++) list[Integer.parseInt(br.readLine())] = true;
        int cnt = 0;
        for (int i = 1; i <= K; i++) cnt+=list[i] ? 1 : 0;
        int ans = cnt;
        for (int i=K+1;i<=N;i++){
            cnt-=list[i-K]? 1 : 0;
            cnt+=list[i] ? 1 : 0;
            ans = Math.min(ans, cnt);
        }
        System.out.println(ans);
    }
}