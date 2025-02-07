import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x,y;
        int v;
        Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.v, o.v);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans =-1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] city = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) city[i][j] = Integer.parseInt(st.nextToken());
        }
        if (city[0][0]!=-1){
            int[][] visit = new int[N][M];
            for (int i = 0; i < N; i++) Arrays.fill(visit[i], Integer.MAX_VALUE);
            int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0,0,city[0][0]));
            visit[0][0] = city[0][0];
            while (!pq.isEmpty()) {
                Node now = pq.poll();
                if (now.x==N-1 && now.y==M-1){
                    ans = now.v;
                    break;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = now.x+dx[d], ny = now.y+dy[d];
                    if (nx<0 || ny<0 || nx>=N || ny>=M || city[nx][ny]==-1) continue;
                    if (visit[nx][ny]<=now.v+city[nx][ny]) continue;
                    visit[nx][ny]=now.v+city[nx][ny];
                    pq.add(new Node(nx,ny,visit[nx][ny]));
                }
            }
        }
        System.out.print(ans);
    }
}
