import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        while (true){
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            long cur = 0,res = Long.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(br.readLine());
                cur = Math.max(cur+p,p);
                res = Math.max(res,cur);
            }
            ans.append(res).append("\n");
        }
        System.out.println(ans);
    }
}