import java.io.*;
import java.util.*;

public class Main {
    static class Road{
        int to;
        double l;
        Road(int to,double l){
            this.to=to;
            this.l=l;
        }
    }

    static class Node implements Comparable<Node>{
        int x;
        double v;
        Node(int x,double v){
            this.x=x;
            this.v=v;
        }
        @Override
        public int compareTo(Node o) {
            return Double.compare(this.v,o.v);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        double L = Double.parseDouble(br.readLine());
        int N = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<Road>[] arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(),i);
            arr[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            double d = Double.parseDouble(input[2]);
            arr[map.get(input[0])].add(new Road(map.get(input[1]),d));
            arr[map.get(input[1])].add(new Road(map.get(input[0]),d));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N];
        pq.add(new Node(0,0));
        double res =0;
        int cnt =0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (cnt==N) break;
            if (visit[node.x]) continue;
            visit[node.x] = true;
            cnt++;
            res += node.v;
            for (Road road : arr[node.x]) {
                if (visit[road.to]) continue;
                pq.add(new Node(road.to,road.l));
            }
        }
        if (res>L || cnt!=N) ans.append("Not enough cable");
        else ans.append("Need "+String.format("%.1f",res)+" miles of cable");
        System.out.print(ans);
    }
}
