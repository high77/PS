import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] bridge = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) bridge[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken())-1
                , e = Integer.parseInt(st.nextToken())-1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, 0});
        boolean[] visit = new boolean[N];
        visit[s] = true;
        int ans = -1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0]==e) {
                ans = now[1];
                break;
            }
            for (int i = 1; i < 10000; i++) {
                int nx = now[0] + i*bridge[now[0]];
                if (nx >= N) break;
                if (visit[nx]) continue;
                visit[nx] = true;
                q.add(new int[]{nx, now[1]+1});
            }
            for (int i = 1; i < 10000; i++) {
                int nx = now[0] - i*bridge[now[0]];
                if (nx<0) break;
                if (visit[nx]) continue;
                visit[nx] = true;
                q.add(new int[]{nx, now[1]+1});
            }

        }
        System.out.println(ans);
    }

}