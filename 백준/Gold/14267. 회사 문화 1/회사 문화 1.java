import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] compliment, res;
    static void dfs(int idx, int curV){
        int v = curV+compliment[idx];
        res[idx] = v;
        for (int i : arr[idx]) dfs(i,v);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        compliment = new int[N+1];
        res = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = new ArrayList<>();
            String s = st.nextToken();
            if (i!=1) arr[Integer.parseInt(s)].add(i);
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            compliment[Integer.parseInt(st.nextToken())]+=Integer.parseInt(st.nextToken());
        }
        dfs(1,0);
        for (int i=1; i<=N; i++) {
            ans.append(res[i]);
            if (i!=N) ans.append(" ");
        }
        System.out.println(ans);
    }
}
