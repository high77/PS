import java.io.*;
        import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            int cnt =0;
            int[][] box = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) box[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j] == 1) {
                        for (int k = i+1; k < n; k++) {
                            if (box[k][j]==0) cnt++;
                        }
                    }
                }
            }
            ans.append(cnt);
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
