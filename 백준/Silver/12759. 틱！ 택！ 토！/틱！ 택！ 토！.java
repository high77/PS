import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int player = Integer.parseInt(br.readLine()); // 시작 플레이어 (1 또는 2)
        int[][] board = new int[4][4];
        int winner = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 승자가 아직 정해지지 않았을 때만 보드 기록 및 체크
            if (winner == 0) {
                board[r][c] = player;
                if (check(board, r, c)) {
                    winner = player;
                }
            }
            // 플레이어 교체 (1 -> 2, 2 -> 1)
            player = (player == 1) ? 2 : 1;
        }
        System.out.println(winner);
    }

    // 승리 조건 체크 함수
    static boolean check(int[][] b, int r, int c) {
        int p = b[r][c];
        // 가로, 세로 체크
        if (b[r][1] == p && b[r][2] == p && b[r][3] == p) return true;
        if (b[1][c] == p && b[2][c] == p && b[3][c] == p) return true;
        
        // 대각선 체크 (좌상단-우하단)
        if (b[1][1] == p && b[2][2] == p && b[3][3] == p) return true;
        // 대각선 체크 (우상단-좌하단)
        if (b[1][3] == p && b[2][2] == p && b[3][1] == p) return true;

        return false;
    }
}