import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int t = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            if (r == 0) break;

            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            double d = Math.sqrt((long) w * w + (long) l * l);
            ans.append("Pizza ")
                    .append(t++)
                    .append(d <= 2 * r ? " fits on the table." : " does not fit on the table.")
                    .append('\n');
        }

        System.out.println(ans);
    }
}
