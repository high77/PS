import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken());
        boolean[][] visit = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1
                    , b = Integer.parseInt(st.nextToken())-1;
            visit[a][b] = true;
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][k] && visit[k][j]) visit[i][j] = true;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            int cnt =0;
            for (int j = 0; j < N; j++) {
                if (visit[i][j] || visit[j][i]) cnt++;
            }
            if (cnt == N-1) ans++;
        }
        System.out.print(ans);
    }
}
