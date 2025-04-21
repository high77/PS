import java.io.*;
import java.util.*;
public class Main{
    static char[][] field = new char[12][6];
    static int[] dx = {0,0,-1,1}, dy = {1,-1,0,0};
    static boolean[][] visit;
    static boolean check = false;

    static void bfs(int x,int y, char color){
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        q1.add(new int[]{x,y});
        q2.add(new int[]{x,y});
        int res = 1;
        while(!q1.isEmpty()){
            int[] cur = q1.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                if (nx<0 || ny<0 || nx>=12 || ny>=6 || visit[nx][ny] || field[nx][ny]!=color) continue;
                visit[nx][ny] = true;
                res++;
                q1.offer(new int[]{nx,ny});
                q2.offer(new int[]{nx,ny});
            }
        }

        if (res<4) return;
        check = true;
        while(!q2.isEmpty()){
            int[] cur = q2.poll();
            field[cur[0]][cur[1]] = '.';
        }
    }

    static void down(){
        for (int i = 0; i < 6; i++) {
            boolean c = false;
            int idx = 0;
            for (int j = 11; j >= 0; j--) {
                if (!c){
                    if (field[j][i]=='.') {
                        c = true;
                        idx = j;
                    }
                }
                else {
                    if (field[j][i]!='.') {
                        field[idx][i] = field[j][i];
                        field[j][i] = '.';
                        idx--;
                    }
                }
            }
        }
    }


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans =0;
        for (int i = 0; i < 12; i++) field[i] = br.readLine().toCharArray();
        while (true) {
            visit = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (visit[i][j] || field[i][j]=='.') continue;
                    visit[i][j] = true;
                    bfs(i,j,field[i][j]);
                }
            }
            if (!check) break;
            ans++;
            check = false;
            down();
        }
        System.out.println(ans);
    }
}