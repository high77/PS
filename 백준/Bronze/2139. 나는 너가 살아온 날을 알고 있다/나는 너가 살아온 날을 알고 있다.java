import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int[] list = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken()),
                    m = Integer.parseInt(st.nextToken()),
                    y = Integer.parseInt(st.nextToken());

            if (d == 0 && m == 0 && y == 0) break;

            int res = 0;
            boolean year29 = (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0));

            if (year29 && m > 2) res++;

            for (int i = 0; i < m; i++) res += list[i];
            res += d;
            ans.append(res).append("\n");
        }

        System.out.println(ans);
    }
}
