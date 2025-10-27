import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][N];
        int[][] dir = {{1,0},{0,1}};
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        boolean flag = false;
        boolean[][] visit = new boolean[M][N];
        visit[0][0] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == M-1 && cur.y == N-1) {
                flag = true;
                break;
            }
            for (int[] d : dir) {
                int nx = cur.x + d[0], ny = cur.y + d[1];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N || arr[nx][ny] == 0 || visit[nx][ny]) continue;
                q.add(new Node(nx,ny));
                visit[nx][ny] = true;
            }
        }
        System.out.println(flag ? "Yes" : "No");
    }
}