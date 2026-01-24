import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve(0, 0, N));
    }

    static int solve(int r, int c, int n) {
        if (n == 1) return map[r][c];
        int half = n / 2;
        int[] candidates = new int[4];
        candidates[0] = solve(r, c, half);            // 왼쪽 위
        candidates[1] = solve(r, c + half, half);     // 오른쪽 위
        candidates[2] = solve(r + half, c, half);     // 왼쪽 아래
        candidates[3] = solve(r + half, c + half, half); // 오른쪽 아래

        Arrays.sort(candidates);
        return candidates[1];
    }
}