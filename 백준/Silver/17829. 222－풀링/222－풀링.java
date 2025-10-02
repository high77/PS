import java.io.*;
import java.util.*;

public class Main {

    static int[][] paper = new int[1025][1025];
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) paper[i][j] = Integer.parseInt(st.nextToken());
        }

        make(N);
        ans.append(paper[0][0]);
        System.out.print(ans);
    }

    static void make(int size) {
        if (size == 1) return;

        for (int i = 0; i < size; i += 2) {
            for (int j = 0; j < size; j += 2) {
                int[] tmp = {paper[i][j], paper[i][j+1], paper[i+1][j], paper[i+1][j+1]};
                Arrays.sort(tmp);
                paper[i/2][j/2] = tmp[2];
            }
        }
        make(size / 2);
    }
}
