import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        boolean[][] visit = new boolean[M][N];

        int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
        int x=0,y=0,d= 0,cnt=1;
        visit[x][y] = true;

        while (N*M>cnt) {
            int nx = x+dx[d], ny=y+dy[d];
            if (nx<0 || ny<0 || nx>=M || ny>=N || visit[nx][ny])  d= (d+1)%4;
            else{
                x = nx;
                y = ny;
                cnt++;
                visit[x][y] = true;
            }
        }
        ans.append(y+" "+x);
        System.out.println(ans);
    }
}