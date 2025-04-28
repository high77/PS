import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] list = new int[N+1];
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()), prev = Integer.parseInt(st.nextToken());
            for (int j = 1; j < k; j++) {
                int now = Integer.parseInt(st.nextToken());
                arr[prev].add(now);
                list[now]++;
                prev = now;
            }
        }

        boolean[] visit = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (list[i] == 0) q.add(i);
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            ans.append(now+"\n");
            cnt++;
            if (visit[now]) {
                System.out.println(0);
                return;
            };
            visit[now] = true;
            for (int i:arr[now]) {
                list[i]--;
                if (list[i] == 0) q.add(i);
            }
        }
        if (cnt == N) System.out.println(ans);
        else System.out.println(0);
    }
}