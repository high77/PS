import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());    
            long[] pig = new long[7];
            long pig_sum = 0;
            int cnt = 1;

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 6; j++) {
                pig[j] = Long.parseLong(st.nextToken());
                pig_sum += pig[j];
            }

            while (pig_sum <= N) {
                pig_sum *= 4;
                cnt++;
            }
            ans.append(cnt).append("\n");
        }
        System.out.println(ans);


    }
}