import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] points = new int[N][2];
        long[] countX = new long[100001];
        long[] countY = new long[100001];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            points[i][0] = x;
            points[i][1] = y;
            
            // 각 좌표의 등장 횟수 카운트
            countX[x]++;
            countY[y]++;
        }

        long totalTriangles = 0;

        for (int i = 0; i < N; i++) {
            int x = points[i][0];
            int y = points[i][1];

            // (현재 점을 제외한 같은 x축 점의 개수) * (현재 점을 제외한 같은 y축 점의 개수)
            long vx = countX[x] - 1;
            long vy = countY[y] - 1;
            
            totalTriangles += vx * vy;
        }

        System.out.println(totalTriangles);
    }
}
