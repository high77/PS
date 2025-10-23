import java.io.*;
        import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] d = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) d[i][j] = line.charAt(j) - '0';
        }
        int ans = 0;
        int[][] output = new int[N][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int max = 0;
                if (i == 0) output[j][i] = d[j][i];
                else {
                    if (j - 1 >= 0) max = Math.max(max, output[j - 1][i - 1]);
                    max = Math.max(output[j][i - 1], max);
                    if (j + 1 < N) max = Math.max(max, output[j + 1][i - 1]);
                    ans = Math.max(max, ans);
                    output[j][i] = max + d[j][i];
                }
            }
        }
        System.out.println(ans);
    }
}
