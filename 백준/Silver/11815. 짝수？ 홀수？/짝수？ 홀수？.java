import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            long X = Long.parseLong(st.nextToken());
            long s = (long)Math.sqrt(X);

            if (s * s == X) ans.append("1");
            else ans.append("0");

            if (i < N - 1) ans.append(" ");
        }

        System.out.println(ans);
    }
}
