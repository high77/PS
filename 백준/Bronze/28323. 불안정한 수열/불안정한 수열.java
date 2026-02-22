import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int prev = Integer.parseInt(st.nextToken()) % 2;
        int ans = 1;

        for (int i = 1; i < N; i++) {
            int curr = Integer.parseInt(st.nextToken()) % 2;

            if (curr != prev) {
                ans++;
                prev = curr;
            }
        }

        System.out.println(ans);
    }
}