import java.io.*;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Point p) {
            // 원점 기준 각도 오름차순 (y/x < p.y/p.x -> y*p.x < p.y*x)
            int angleCompare = Integer.compare(this.y * p.x, this.x * p.y);
            if (angleCompare != 0) {
                return angleCompare;
            }
            // 각도가 같으면 거리 오름차순
            return Integer.compare(this.x * this.x + this.y * this.y, p.x * p.x + p.y * p.y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        
        int N = Integer.parseInt(line.trim());
        Point[] pts = new Point[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pts[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(pts);

        int[][] dp = new int[N][N];
        int maxVertices = 0;
        Point origin = new Point(0, 0);

        // DP 초기화: 원점과 두 점을 연결하여 만들 수 있는 기본 삼각형(꼭짓점 3개) 세팅
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (ccw(origin, pts[i], pts[j]) > 0) {
                    dp[i][j] = 3;
                    maxVertices = Math.max(maxVertices, dp[i][j]);
                }
            }
        }

        // DP 전이: 기존 다각형에 새로운 점 k를 이어붙임
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i][j] >= 3) {
                    for (int k = j + 1; k < N; k++) {
                        // 연속된 변이 평행하지 않고(strictly convex) 좌회전인지 확인
                        if (ccw(origin, pts[j], pts[k]) > 0 && ccw(pts[i], pts[j], pts[k]) > 0) {
                            dp[j][k] = Math.max(dp[j][k], dp[i][j] + 1);
                            maxVertices = Math.max(maxVertices, dp[j][k]);
                        }
                    }
                }
            }
        }

        System.out.println(maxVertices);
    }

    // 벡터의 외적을 이용한 CCW(Counter Clockwise) 판별 함수
    static int ccw(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }
}