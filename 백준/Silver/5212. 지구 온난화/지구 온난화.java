import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken())
                , up = R, down = 0, left = C, right = 0,cnt;

        char[][] arr = new char[R][C];

        for (int i = 0; i < R; i++) arr[i] = br.readLine().toCharArray();


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 'X') {
                    cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d], ny = j + dy[d];

                        if (nx >= 0 && ny >= 0 && nx < R && ny < C) { // 지도 안에 있을경우
                            if (arr[nx][ny] == '.') cnt++;
                        } else cnt++;

                    }
                    if (cnt >= 3) arr[i][j] = 'S';

                }
                if (arr[i][j] == 'X') {
                    up = Math.min(up, i);
                    down = Math.max(down, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }

        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                char c = arr[i][j];
                if (c == 'X') ans.append(c);
                else ans.append('.');
            }
            ans.append('\n');
        }
        System.out.println(ans);
    }
}