import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc=0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine());
            char[] start = br.readLine().toCharArray(), end = br.readLine().toCharArray();
            int W =0, B = 0;
            for (int i = 0; i < N; i++) {
                if (start[i] != end[i]) {
                    if (start[i] == 'W') W++;
                    else if (start[i] == 'B') B++;
                }
            }
            ans.append(W+B-Math.min(W, B)+"\n");
        }

        System.out.println(ans);
    }
}