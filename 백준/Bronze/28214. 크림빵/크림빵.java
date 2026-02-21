import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , K = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken())
                , ans =0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cnt = K;
            for (int j = 0; j < K; j++) cnt -= Integer.parseInt(st.nextToken());
            if (cnt < P) ans++;
        }

        System.out.println(ans);
    }
}