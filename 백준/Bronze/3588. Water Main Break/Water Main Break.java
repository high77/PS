import java.io.*;
import java.util.*;

public class Main {

       public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()),F = Integer.parseInt(st.nextToken());
            int res = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()),b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
                int s = Math.max(a,S), e = Math.min(b,F);
                if (s<=e) res += (e-s+1)*c;
            }
            ans.append("Data Set "+tc+":"+"\n");
            ans.append(res+"\n\n");
        }
        System.out.print(ans);
    }
}
