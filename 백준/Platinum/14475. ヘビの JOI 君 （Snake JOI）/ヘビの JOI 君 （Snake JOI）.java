import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, d, next;
        Edge(int to, int d, int next) {
            this.to = to; this.d = d; this.next = next;
        }
    }

    static class Node implements Comparable<Node> {
        int u, type, t;
        long cost;
        Node(int u, int type, int t, long cost) {
            this.u = u; this.type = type; this.t = t; this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] T = new int[N + 1];
        for (int i = 1; i <= N; i++) T[i] = Integer.parseInt(br.readLine());

        int[] head = new int[N + 1];
        Arrays.fill(head, -1);
        Edge[] edges = new Edge[M * 2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edges[i * 2] = new Edge(v, d, head[u]);
            head[u] = i * 2;
            edges[i * 2 + 1] = new Edge(u, d, head[v]);
            head[v] = i * 2 + 1;
        }

        // dist[room][type][time] -> 1D array optimization
        // type: 0(Cold), 1(Neutral), 2(Hot)
        long[] dist = new long[(N + 1) * 3 * (X + 1)];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 초기 상태: 1번 방(추움), 타입 0, 남은 시간 X
        int startIdx = (1 * 3 + 0) * (X + 1) + X;
        dist[startIdx] = 0;
        pq.add(new Node(1, 0, X, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.cost > dist[(curr.u * 3 + curr.type) * (X + 1) + curr.t]) continue;
            if (curr.u == N) {
                System.out.println(curr.cost);
                return;
            }

            for (int i = head[curr.u]; i != -1; i = edges[i].next) {
                Edge e = edges[i];
                int nextType = curr.type;
                int nextT = Math.max(0, curr.t - e.d);

                if (T[e.to] == 0) { // 이동할 방이 추움
                    if (curr.type == 2 && nextT > 0) continue; // 더움 영향 남아있으면 불가
                    nextType = 0;
                    nextT = X;
                } else if (T[e.to] == 2) { // 이동할 방이 더움
                    if (curr.type == 0 && nextT > 0) continue; // 추움 영향 남아있으면 불가
                    nextType = 2;
                    nextT = X;
                }
                // 적당한 방(T=1)인 경우 기존 type과 줄어든 nextT 유지

                int nextIdx = (e.to * 3 + nextType) * (X + 1) + nextT;
                if (dist[nextIdx] > curr.cost + e.d) {
                    dist[nextIdx] = curr.cost + e.d;
                    pq.add(new Node(e.to, nextType, nextT, dist[nextIdx]));
                }
            }
        }
    }
}