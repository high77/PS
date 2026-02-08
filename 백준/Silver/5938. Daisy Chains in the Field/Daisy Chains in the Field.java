import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int N ;
    static boolean[] visit;
    static void dfs(int x){
        visit[x] = true;
        for (int n:arr[x]) {
            if (visit[n]) continue;
            dfs(n);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        visit = new boolean[N+1];
        dfs(1);
        boolean flag = false;
        for (int i = 2; i < N+1; i++) {
            if (visit[i]) continue;
            flag = true;
            ans.append(i).append("\n");
        }
        System.out.println(flag?ans:0);
    }
}