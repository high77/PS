import java.io.*;
import java.util.*;

public class Main {
    static int M, N, g[][];
    static boolean[][] a;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            M = Integer.parseInt(br.readLine().trim());
            N = Integer.parseInt(br.readLine().trim());
            g = new int[M][N]; a = new boolean[M][N];

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    g[i][j] = Integer.parseInt(st.nextToken());
                    a[i][j] = true;
                }
            }

            int turns = 0;
            Set<String> hist = new HashSet<>();
            while (true) {
                // 1. 연쇄 제거
                while (true) {
                    boolean chk = false;
                    for (int r = 0; r < M; r++) for (int c = 0; c < N; c++) {
                        if (a[r][c] && (g[r][c] < 12 || cnt(r, c) == 0)) {
                            a[r][c] = false; chk = true;
                        }
                    }
                    if (!chk) break;
                }

                int live = 0;
                for (int r = 0; r < M; r++) for (int c = 0; c < N; c++) if (a[r][c]) live++;

                if (live == 0) {
                    ans.append("Case #").append(t).append(": ").append(turns).append(" turns\n");
                    break;
                }

                // 2. 무한 루프 감지
                String s = Arrays.deepToString(g) + Arrays.deepToString(a);
                if (!hist.add(s)) {
                    ans.append("Case #").append(t).append(": ").append(live).append(" children will play forever\n");
                    break;
                }

                // 3. 동시 교환
                int[][] ng = new int[M][N];
                for (int r = 0; r < M; r++) for (int c = 0; c < N; c++) {
                    if (a[r][c]) {
                        int nb = cnt(r, c);
                        ng[r][c] += g[r][c] - 12;
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d], nc = c + dc[d];
                            if (nr >= 0 && nr < M && nc >= 0 && nc < N && a[nr][nc])
                                ng[nr][nc] += 12 / nb;
                        }
                    }
                }
                g = ng; turns++;
            }
        }
        System.out.println(ans);
    }

    static int cnt(int r, int c) {
        int n = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d], nc = c + dc[d];
            if (nr >= 0 && nr < M && nc >= 0 && nc < N && a[nr][nc]) n++;
        }
        return n;
    }
}