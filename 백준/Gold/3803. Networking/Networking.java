import java.io.*;
import java.util.*;

public class Main {
    static class Cable{
        int to,v;
        Cable(int to,int v){
            this.to=to;
            this.v=v;
        }
    }
    static class Node implements Comparable<Node>{
        int x,v;
        Node(int x,int v){
            this.x=x;
            this.v=v;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.v,o.v);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st ;
        while (true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n==0) break;
            int m = Integer.parseInt(st.nextToken());
            ArrayList<Cable>[] arr = new ArrayList[n+1];
            for (int i=1;i<=n;i++) arr[i] = new ArrayList<>();
            for (int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()),b = Integer.parseInt(st.nextToken())
                        ,c = Integer.parseInt(st.nextToken());
                arr[a].add(new Cable(b,c));
                arr[b].add(new Cable(a,c));
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int cnt = 0,res = 0;
            boolean[] visit = new boolean[n+1];
            pq.add(new Node(1,0));
            while (!pq.isEmpty()){
                Node node = pq.poll();
                if (cnt==n) break;
                if (visit[node.x]) continue;
                visit[node.x] = true;
                cnt++;
                res+=node.v;
                for (Cable cable:arr[node.x]){
                    if (visit[cable.to]) continue;
                    pq.add(new Node(cable.to,cable.v));
                }
            }
            ans.append(res+"\n");
            br.readLine();
        }

        System.out.println(ans);
    }
}
