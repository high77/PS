import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N+1];
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int max = 0;
            for (int j = 0; j < m; j++) max = Math.max(max, time[Integer.parseInt(st.nextToken())]);
            time[i] += max;
            ans = Math.max(ans, time[i]);
        }
        System.out.println(ans);
    }
}
