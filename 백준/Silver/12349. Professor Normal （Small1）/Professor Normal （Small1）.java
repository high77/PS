import java.io.*;
import java.util.*;

public class Main {
    static int M, N, g[][];
    static boolean[][] a;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        if (line == null) return;
        int T = Integer.parseInt(line.trim());

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
            // 메모리 절약을 위해 String 대신 List<int[][]>나 커스텀 해시 사용 가능하지만,
            // Small1 범위에서는 중복 체크용으로 아래 방식이 효율적입니다.
            Set<String> hist = new HashSet<>();
            while (true) {
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
                    sb.append("Case #").append(t).append(": ").append(turns).append(" turns\n");
                    break;
                }

                // 메모리 핵심: 상태를 더 짧은 문자열로 압축하거나 해시값만 저장
                String s = encodeState();
                if (!hist.add(s)) {
                    sb.append("Case #").append(t).append(": ").append(live).append(" children will play forever\n");
                    break;
                }

                int[][] ng = new int[M][N];
                for (int r = 0; r < M; r++) {
                    for (int c = 0; c < N; c++) {
                        if (!a[r][c]) continue;
                        int nb = cnt(r, c);
                        ng[r][c] += g[r][c] - 12;
                        int share = 12 / nb;
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d], nc = c + dc[d];
                            if (nr >= 0 && nr < M && nc >= 0 && nc < N && a[nr][nc])
                                ng[nr][nc] += share;
                        }
                    }
                }
                g = ng; turns++;
            }
        }
        System.out.print(sb);
    }

    static int cnt(int r, int c) {
        int n = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d], nc = c + dc[d];
            if (nr >= 0 && nr < M && nc >= 0 && nc < N && a[nr][nc]) n++;
        }
        return n;
    }

    // Arrays.deepToString보다 메모리 효율적인 상태 요약
    static String encodeState() {
        StringBuilder tmp = new StringBuilder();
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (a[r][c]) tmp.append(g[r][c]).append(',');
                else tmp.append('X');
            }
        }
        return tmp.toString();
    }
}