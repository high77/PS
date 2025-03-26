import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken())
                    , K = Long.parseLong(st.nextToken());
            if (N == 0 && K == 0) break;
            long res = 1;

            if (K > N - K) K = N - K;
            for (long i = 1; i <= K; i++) {
                res *= N--;
                res /= i;
            }
            ans.append(res+"\n");
        }
        System.out.println(ans);
    }
}