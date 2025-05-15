import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[] list = new int[N];



        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(br.readLine());
        long s = 0, e = 1000000000+K, ans = 0;
        while (s <= e) {
            long mid = (e + s) / 2, sum = 0;
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                sum += Math.max(mid - list[i],0);
                if (sum>K) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                s = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                e = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
