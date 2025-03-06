import java.io.*;
import java.util.*;

public class Main {
    static class Road {
        int to,v;
        Road(int to, int v) {
            this.to = to;
            this.v = v;
        }
    }
    static class Node implements Comparable<Node> {
        int x,v;
        Node(int x, int v) {
            this.x = x;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken())
                , S = Integer.parseInt(st.nextToken())
                , E = Integer.parseInt(st.nextToken());
        ArrayList<Road>[] arr = new ArrayList[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken())
                    , c = Integer.parseInt(st.nextToken());
            arr[a].add(new Road(b, c));
            arr[b].add(new Road(a, c));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(S,0));
        dist[S] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.v>dist[cur.x]) continue;
            if (cur.x==E) break;
            for (Road road : arr[cur.x]) {
                if (dist[road.to]>cur.v+road.v){
                    dist[road.to] = cur.v+road.v;
                    pq.offer(new Node(road.to,cur.v+road.v));
                }
            }
        }
        System.out.println(dist[E]);
    }
}
