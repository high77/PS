import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] farm;
    static boolean[][] visit ;
    static int[] dx = {1,1,1,-1,-1,-1,0,0}, dy = {-1,0,1,-1,0,1,-1,1};
    static boolean bfs(int x, int y){
        boolean flag = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visit[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if (!flag) break;
            for (int d = 0;d<8;d++){
                int nx = cur[0] + dx[d], ny = cur[1]+dy[d];
                if (nx<0 || nx>=N || ny<0 || ny>=M || visit[nx][ny]) continue;
                if (farm[x][y]== farm[nx][ny]) {
                    if (!check(nx,ny)) {
                        flag =false;
                    }
                    visit[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                };
            }
        }
        return flag;
    }

    static boolean check(int x, int y){
        boolean flag = true;
        for (int d = 0;d<8;d++){
            int nx = x + dx[d], ny = y+dy[d];
            if (nx<0 || nx>=N || ny<0 || ny>=M ) continue;
            if (farm[nx][ny] > farm[x][y]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        farm = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) farm[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (farm[i][j] !=0 && !visit[i][j] && check(i,j) && bfs(i,j)) ans++;
            }
        }
        System.out.println(ans);

    }

}