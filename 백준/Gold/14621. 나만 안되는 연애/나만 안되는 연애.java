import java.util.*;
import java.io.*;
public class Main {
    static class Node implements Comparable<Node> {
        int school, curV;
        Node(int school, int curV){
            this.school = school;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        String[] gender = br.readLine().split(" ");
        ArrayList<int[]>[] arr = new ArrayList[N];
        for (int i = 0; i < N; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1
                    , v = Integer.parseInt(st.nextToken());
            arr[a].add(new int[] {b, v});
            arr[b].add(new int[] {a, v});
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        boolean[] visit = new boolean[N];
        int cnt =0 , res = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cnt == N) break;
            if (!visit[cur.school]) {
                visit[cur.school] = true;
                cnt++;
                res+=cur.curV;
                for (int[] next:arr[cur.school]) {
                    if (!visit[next[0]] && !gender[next[0]].equals(gender[cur.school])) pq.offer(new Node(next[0], next[1]));
                }
            }
        }
        if (cnt!=N) res = -1;
        System.out.println(res);
    }
}
