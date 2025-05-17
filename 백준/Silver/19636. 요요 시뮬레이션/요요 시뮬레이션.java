import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken()), basic = Integer.parseInt(st.nextToken())
                , t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(st.nextToken()), d_input = Integer.parseInt(st.nextToken())
                , d_output = Integer.parseInt(st.nextToken());

        int w1 = w;
        int w2 = w;
        int basic2 = basic;

        for (int i = 0; i < day; i++) {
            w1 += d_input - (basic + d_output);
            w2 += d_input - (basic2 + d_output);

            if (Math.abs(d_input - (basic2 + d_output)) > t) basic2 += (int) Math.floor((d_input - (basic2 + d_output)) / 2.0);
        }

        if (w1 <= 0) ans.append("Danger Diet\n");
        else ans.append(w1).append(" ").append(basic).append("\n");

        if (w2 <= 0 || basic2 <= 0) ans.append("Danger Diet\n");
        else {
            ans.append(w2).append(" ").append(basic2).append(" ");
            if (basic - basic2 > 0) ans.append("YOYO\n");
            else ans.append("NO\n");
        }

        System.out.print(ans);
    }
}