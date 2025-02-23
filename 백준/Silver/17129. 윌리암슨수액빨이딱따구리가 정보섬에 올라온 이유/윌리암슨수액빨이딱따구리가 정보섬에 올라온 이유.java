import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int x,y,cnt;
        Node(int x,int y,int cnt){
            this.x=x;
            this.y=y;
            this.cnt = cnt;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()),res = -1;
        int[][] island = new int[N][M];
        int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
        int X=0,Y=0;
        for (int i=0;i<N;i++){
            char[] s = br.readLine().toCharArray();
            for (int j=0;j<M;j++) {
                island[i][j] = s[j]-'0';
                if (s[j] == '2') {
                    X = i;
                    Y=j;
                }
            }
        }
        boolean[][] visit = new boolean[N][M];
        Queue<Node> q = new ArrayDeque<>();
        visit[X][Y] = true;
        q.add(new Node(X,Y,0));
        while (!q.isEmpty()){
            Node now = q.poll();
            if (island[now.x][now.y]>=3){
                res = now.cnt;
                break;
            }
            for (int d=0;d<4;d++){
                int nx = dx[d]+now.x, ny = dy[d]+now.y;
                if (nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny] || island[nx][ny] == 1) continue;
                visit[nx][ny] = true;
                q.add(new Node(nx,ny,now.cnt+1));
            }
        }
        if (res!=-1) ans.append("TAK\n"+res);
        else ans.append("NIE");
        System.out.println(ans);
    }
}
