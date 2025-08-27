import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] check = new int[101][3], scores = new int[N][3];
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
                check[scores[i][j]][j]++;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (check[scores[i][j]][j]==1) res[i]+=scores[i][j];
            }
        }
        for (int i = 0; i < N; i++) ans.append(res[i]).append("\n");
        System.out.println(ans);
    }
}