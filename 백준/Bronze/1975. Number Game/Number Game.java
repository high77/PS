import java.io.*;
        import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int cnt = 0;
            int N = Integer.parseInt(br.readLine());
            for(int j = 2; j <= N; j++) {
                int val = N;
                while(true) {
                    if(val % j != 0) break;
                    cnt++;
                    val /= j;
                }
            }
            ans.append(cnt);
            ans.append("\n");
        }
        System.out.println(ans);
    }
}