import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] list = new long[N];
        for (int i = 0; i < N; i++) list[i] = Long.parseLong(st.nextToken());
        boolean finish = false;
        int ans =1;
        for (int i = 0; i < N; i++) {
            K-=list[i];
            if (K<0) {
                finish = true;
                ans += i;
                break;
            }
        }
        if (!finish) {
            for (int i=N-1; i>=0; i--) {
                K-=list[i];
                if (K<0) {
                    ans+=i;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
