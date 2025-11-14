import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] diff = new int[10002];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())
                    , y = Integer.parseInt(st.nextToken());
            if (x > y) { int t = x; x = y; y = t; }

            diff[x]++;   
            diff[y]--;   
        }

        int ans = 0, active = 0;

        for (int i = 1; i <= 10000; i++) {
            active += diff[i]; 
            if (active > 0) ans++;
        }

        System.out.println(ans);
    }
}
