import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int x,y,cnt;
        Node(int x,int y,int cnt){
            this.x = x;
            this.y= y;
            this.cnt = cnt;
        }

    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),M = Integer.parseInt(st.nextToken());
        int[][] chess = new int[N][N];
        int[] res = new int[M];
        int[] dx = {-2,-2,-1,-1,1,1,2,2}, dy = {-1,1,-2,2,-2,2,-1,1};
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken())-1, Y = Integer.parseInt((st.nextToken()))-1;
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            chess[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=i+1;
        }
        boolean[][] visit = new boolean[N][N];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(X,Y,0));
        visit[X][Y] = true;
        while (!q.isEmpty()){
            Node now = q.poll();
            if (chess[now.x][now.y] !=0) res[chess[now.x][now.y]-1] = now.cnt;
            for (int d=0;d<8;d++){
                int nx = dx[d]+now.x, ny = dy[d]+now.y;
                if (nx<0 || ny <0 || nx>=N || ny>=N || visit[nx][ny]) continue;
                visit[nx][ny] = true;
                q.add(new Node(nx,ny,now.cnt+1));
            }
        }
        for (int i :res) ans.append(i+" ");
        System.out.println(ans);
    }
}
