import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int res ;
    static int[][] ability ;
    static boolean[][] visit;
    static void f(int k,int curV){
        if (k==11) {
            res = Math.max(res,curV);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (visit[i][k] || ability[i][k]==0) continue;
            Arrays.fill(visit[i],true);
            f(k+1,curV+ability[i][k]);
            Arrays.fill(visit[i],false);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            res =0;
            ability = new int[11][11];
            visit = new boolean[11][11];
            for (int i=0;i<11;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0;j<11;j++) ability[i][j] = Integer.parseInt(st.nextToken());
            }
            f(0,0);
            ans.append(res+"\n");
        }
        System.out.println(ans);
    }
}