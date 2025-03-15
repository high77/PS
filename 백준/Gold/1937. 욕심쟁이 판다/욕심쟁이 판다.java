import java.io.*;
import java.util.*;

public class Main {

    static int N,ans=0;
    static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    static int[][] arr,dp;

    static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];
        dp[x][y] = 1;
        for (int d=0; d<4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx<0 || ny<0 || nx>=N || ny>=N) continue;
            if (arr[nx][ny] > arr[x][y]) dp[x][y] = Math.max(dp[x][y], dfs(nx, ny)+1);
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) ans = Math.max(ans,dfs(i,j));
        }
        System.out.print(ans);
    }


}
