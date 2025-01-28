import java.util.*;
import java.io.*;
public class Main {
    static class Node implements Comparable<Node> {
        int planet, curV;
        Node(int planet, int curV){
            this.planet = planet;
            this.curV = curV;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.curV, o.curV);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) cost[i][j] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        boolean[] visit = new boolean[N];
        int cnt =0;
        long res =0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cnt == N) break;
            if (!visit[cur.planet]) {
                visit[cur.planet] = true;
                cnt++;
                res+=cur.curV;
                for (int i = 0; i < N; i++) {
                    if (!visit[i]) pq.offer(new Node(i, cost[cur.planet][i]));
                }
            }
        }
        System.out.println(res);

    }

}
