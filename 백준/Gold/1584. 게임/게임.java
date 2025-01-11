import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int[][] arr = new int[501][501];
        int N = Integer.parseInt(br.readLine());
        for (int k = 0; k < N; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())
                    , y1 = Integer.parseInt(st.nextToken())
                    , x2 = Integer.parseInt(st.nextToken())
                    , y2 = Integer.parseInt(st.nextToken());
            for (int i = Math.min(x1,x2); i <= Math.max(x1,x2); i++) {
                for (int j = Math.min(y1,y2); j <= Math.max(y1,y2); j++) arr[i][j] = 1;
            }
        }
        int M = Integer.parseInt(br.readLine());
        for (int k = 0; k < M; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())
                    , y1 = Integer.parseInt(st.nextToken())
                    , x2 = Integer.parseInt(st.nextToken())
                    , y2 = Integer.parseInt(st.nextToken());
            for (int i = Math.min(x1,x2); i <= Math.max(x1,x2); i++) {
                for (int j = Math.min(y1,y2); j <= Math.max(y1,y2); j++) arr[i][j] = -1;
            }
        }
        Deque<int[]> q = new LinkedList<>();
        int[][] visit = new int[501][501];
        int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};
        for (int i = 0; i < 501; i++) Arrays.fill(visit[i], Integer.MAX_VALUE);
        visit[0][0] = 0;
        q.add(new int[]{0,0,0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0]==500 && cur[1]==500) break;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i], ny = cur[1] + dy[i];
                if (nx < 0 || nx > 500 || ny < 0 || ny > 500 || arr[nx][ny] == -1 ) continue;
                if (arr[nx][ny] == 1) {
                    if (visit[nx][ny] <= cur[2]+1) continue;
                    visit[nx][ny] = cur[2]+1;
                    q.add(new int[]{nx,ny,cur[2]+1});
                }
                else {
                    if (visit[nx][ny] <= cur[2]) continue;
                    visit[nx][ny] = cur[2];
                    q.addFirst(new int[]{nx,ny,cur[2]});
                }
            }
        }
        System.out.println(visit[500][500]==Integer.MAX_VALUE ?-1: visit[500][500]);
    }
}