import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken())
                    , ID = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            int[][] table = new int[n+1][k+1];
            int[] scores = new int[n+1], cnt = new int[n+1], times = new int[n+1];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int id  = Integer.parseInt(st.nextToken()), num = Integer.parseInt(st.nextToken())
                        , score = Integer.parseInt(st.nextToken());
                times[id] = j;
                cnt[id]++;
                if (table[id][num]<score) {
                    scores[id]-=table[id][num]-score;
                    table[id][num] = score;
                }
            }
            int rank = 1;
            for (int j = 1; j <= n; j++) {
                if (j==ID) continue;
                if (scores[j]>scores[ID]) rank++;
                else if (scores[j]==scores[ID]){
                    if (cnt[j]<cnt[ID]) rank++;
                    else if (cnt[j]==cnt[ID] && times[j]<times[ID]) rank++;
                }
            }
            ans.append(rank).append("\n");
        }
        System.out.println(ans);
    }
}