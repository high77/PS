import java.util.*;
import java.io.*;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = 0;
        while(true) {
            T++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken())
                    , w = Integer.parseInt(st.nextToken());
            if(o == 0 && w == 0) break;

            int cnt = 0;

            while(true) {
                st = new StringTokenizer(br.readLine());
                String S = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if(S.equals("#") && n == 0) break;

                if(S.equals("E")) w -= n;
                if(S.equals("F")) w += n;

                if(w <= 0) cnt = 1;
            }
            if(cnt == 1)ans.append(T + " RIP");
            else {
                if((o / 2) < w && w < (o * 2)) ans.append(T + " :-)");
                else ans.append(T + " :-(");
            }
            ans.append("\n");
        }
        System.out.println(ans);

    }

}
