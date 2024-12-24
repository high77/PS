import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken())
                , X = Integer.parseInt(st.nextToken())-1
                , Y = Integer.parseInt(st.nextToken())-1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];
        int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
        q.add(new int[]{X,Y,0});
        visit[X][Y] = true;
        int min = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[2]>S || min < now[2]) break;
            if (arr[now[0]][now[1]]!=0) {
                ans = Math.min(ans, arr[now[0]][now[1]]);
                min = now[2];
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i], ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) continue;
                visit[nx][ny] = true;
                q.offer(new int[]{nx, ny,now[2]+1});
            }
        }
        System.out.println(ans!=Integer.MAX_VALUE?ans:0);
    }
}
