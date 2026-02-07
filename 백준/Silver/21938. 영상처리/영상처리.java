import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = (Integer.parseInt(st.nextToken())
                        + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) / 3;
            }
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) arr[i][j] = arr[i][j] >= T ? 1: 0;
        }
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 1) continue;
                arr[i][j] = 0;
                q.add(new Node(i, j));
                ans++;
                while (!q.isEmpty()) {
                    Node now = q.poll();
                    for (int d = 0; d < 4; d++) {
                        int nx = now.x + dx[d], ny = now.y + dy[d];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny]==0) continue;
                        arr[nx][ny] = 0;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
        System.out.println(ans);
    }
}