import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken()), ans =0;

        boolean[][] visit = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            visit[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visit[i][k] && visit[k][j]) visit[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int heavy = 0, light = 0;
            for (int j = 1; j <= N; j++) {
                if (visit[i][j]) light++;
                if (visit[j][i]) heavy++;
            }
            if (light > N/2 || heavy > N/2) ans++;
        }

        System.out.println(ans);
    }
}