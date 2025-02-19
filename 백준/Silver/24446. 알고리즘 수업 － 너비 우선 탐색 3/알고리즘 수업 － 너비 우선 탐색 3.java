import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken())
                ,R = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] visit = new int[N+1];
        Arrays.fill(visit, -1);
        q.offer(R);
        visit[R] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : arr[now]) {
                if (visit[next] != -1) continue;
                visit[next] = visit[now] + 1;
                q.offer(next);
            }
        }
        for (int i = 1; i <= N; i++) ans.append(visit[i]+"\n");
        System.out.println(ans);
    }
}
