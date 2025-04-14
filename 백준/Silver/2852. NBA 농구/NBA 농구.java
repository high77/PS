import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int score[] = new int[2], time[] = new int[2], now = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken())-1;
            String tmpT[] = st.nextToken().split(":");
            int tmp = Integer.parseInt(tmpT[0])*60+Integer.parseInt(tmpT[1]);
            if (score[0] > score[1]) time[0] += tmp-now;
            else if (score[0] < score[1]) time[1] += tmp-now;
            now = tmp;
            score[team]++;
        }
        if (score[0] > score[1]) time[0] += 2880-now;
        else if (score[0] < score[1]) time[1] += 2880-now;


        ans.append(String.format("%02d:%02d", time[0]/60, time[0]%60)).append("\n");
        ans.append(String.format("%02d:%02d", time[1]/60, time[1]%60));
        System.out.println(ans);

    }


}