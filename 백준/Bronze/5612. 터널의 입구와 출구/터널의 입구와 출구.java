import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int ans = M;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())
                    , B = Integer.parseInt(st.nextToken());
            M += A-B;
            ans = Math.max(ans, M);
            if(M < 0) {
                ans = 0;
                break;
            }
        }
        System.out.println(ans);
    }

}