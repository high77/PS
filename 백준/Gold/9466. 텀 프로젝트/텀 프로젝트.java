import java.util.*;
import java.io.*;

public class Main{
    static int res, list[];
    static boolean[] visit, done;

    static void dfs(int n){

        if(visit[n]){
            done[n] = true;
            res--;
        }
        else visit[n] = true;

        if(!done[list[n]]) dfs(list[n]);

        visit[n] = false;
        done[n] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans  = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());
            list = new int[N +1];
            visit = new boolean[N +1];
            done = new boolean[N +1];
            res = N;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i<= N; i++) list[i] = Integer.parseInt(st.nextToken());

            for(int i = 1; i<= N; i++){
                if(!done[i]) dfs(i);
            }
            ans.append(res + "\n");
        }
        System.out.println(ans);
    }
}
