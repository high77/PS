import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), max = 0;
        Set<Integer> stain = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) if (s.charAt(j) == '#') stain.add(i * 100 + j);
        }
        br.readLine();

        int[][] stick = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) if (s.charAt(j) == '#') stick[i][j] = 1;
        }

        for (int r = 0; r < 4; r++) {
            List<int[]> cur = new ArrayList<>();
            for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) if (stick[i][j] == 1) cur.add(new int[]{i, j});

            for (int dy = -N; dy <= N; dy++) {
                for (int dx = -N; dx <= N; dx++) {
                    int cnt = 0;
                    for (int[] p : cur) if (stain.contains((p[0] + dy) * 100 + (p[1] + dx))) cnt++;
                    max = Math.max(max, cnt);
                }
            }
            // 90도 회전
            int[][] next = new int[N][N];
            for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) next[j][N - 1 - i] = stick[i][j];
            stick = next;
        }
        System.out.println(stain.size() - max);
    }
}