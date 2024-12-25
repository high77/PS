import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        double[] Pancake = {0.5, 0.5, 0.25, 0.0625, 0.5625};
        int[] Topping = {1, 30, 25, 10};
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            double cnt = 0;
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int n = Integer.parseInt(st.nextToken());
                n /= Pancake[j];
                if (j == 0 || n < cnt) cnt = n;
            }
            int cnt2 = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int n = Integer.parseInt(st.nextToken());
                cnt2 += (n / Topping[j]);
            }
            ans.append((int) Math.min(cnt, cnt2));
            ans.append("\n");
        }
        System.out.println(ans);
    }
}