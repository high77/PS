import java.util.*;
import java.io.*;
public class Main {
    static class Node implements Comparable<Node> {
        int x,v;
        Node(int x,int v){
            this.x=x;
            this.v=v;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.v,this.v);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans  = new StringBuilder();
        int ans =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] arr = new ArrayList[N];
        for (int i = 0; i < N; i++) arr[i]= new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1
                    , c = Integer.parseInt(st.nextToken());
            arr[a].add(new int[]{b, c});
            arr[b].add(new int[]{a, c});
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int cnt = 0;
        boolean[] visit = new boolean[N];
        pq.add(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cnt == N) break;
            if (visit[cur.x]) continue;
            visit[cur.x] = true;
            ans+=cur.v;
            cnt++;
            for (int[] next : arr[cur.x]) {
                if (!visit[next[0]]) pq.offer(new Node(next[0], next[1]));
            }
        }
        if (cnt!=N) ans =-1;
        System.out.println(ans);
    }

}

