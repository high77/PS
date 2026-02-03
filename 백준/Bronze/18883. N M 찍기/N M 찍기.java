import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int res = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                ans.append(res++);
                if (j != M) ans.append(" ");
            }
            ans.append("\n");
        }

        System.out.println(ans);
    }
}