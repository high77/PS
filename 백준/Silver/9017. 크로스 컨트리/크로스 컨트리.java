import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()), i, N, team,j;
        StringTokenizer st;
        
        while (T-->0){
            N = Integer.parseInt(br.readLine());
            int count[] = new int[202];
            int teamNum[] = new int[N];
            st = new StringTokenizer(br.readLine());
            for (i = 0; i < N; i++){
                teamNum[i] = team = Integer.parseInt(st.nextToken());
                count[team]++;
            }
            int score[] = new int[202],passTeam[] = new int[202];
            int min = 1<<30, ans = -1;

            for (i = 0, j=1; i < N; i++){
                team = teamNum[i];
                if (count[team] < 6) continue;
                passTeam[team]++;
                if (passTeam[team] < 5) score[team] += j << 19;
                if (passTeam[team] == 5){
                    score[team] += j;
                    if (score[team] < min){
                        min = score[team];
                        ans = team;
                    }
                }
                j++;
            }
            System.out.println(ans);
        }
    }
}