import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int now,cnt;
        Node(int to, int cnt) {
            this.now = to;
            this.cnt = cnt;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , K = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())
                    , b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        Queue<Node> q;
        boolean[] visit;
        for (int i = 1; i <= N; i++){
            q  = new LinkedList<>();
            visit = new boolean[N+1];
            q.add(new Node(i,0));
            visit[i] = true;
            while (!q.isEmpty()){
                Node cur = q.poll();
                if (cur.cnt >6){
                    flag = false;
                    break;
                }
                for (int nxt:arr[cur.now]) {
                    if (visit[nxt]) continue;
                    q.add(new Node(nxt,cur.cnt+1));
                    visit[nxt] = true;
                }
            }
            if (!flag) break;
            for (int j = 1; j <= N; j++) {
                flag = visit[j];
                if (!flag) break;
            }
        }


        System.out.println(flag ? "Small World!" : "Big World!");
    }

}