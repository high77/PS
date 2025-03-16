import java.io.*;
import java.util.*;

public class Main {
    static int N, INF = 987654321;
    static int[][] W,dp;

    static int tsp(int x, int visit){
        if (visit==(1<<N)-1) return W[x][0]==0?INF:W[x][0];
        if (dp[x][visit]!=-1) return dp[x][visit];
        dp[x][visit]= INF;
        for (int i=0;i<N;i++){
            if ((visit&(1<<i))!=0 || W[x][i]==0) continue;
            dp[x][visit] = Math.min(tsp(i,visit|(1<<i))+W[x][i],dp[x][visit]);
        }
        return dp[x][visit];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][(1<<N)-1];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i],-1);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) W[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(tsp(0,1));
    }


}
