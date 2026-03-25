import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        long x, y;
        int id;
        double angle;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int n = Integer.parseInt(line.trim());
        Point[] P = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            P[i] = new Point();
            P[i].x = Long.parseLong(st.nextToken());
            P[i].y = Long.parseLong(st.nextToken());
            P[i].id = i;
        }

        long[][] emptyLeft = new long[n][n];

        // 1. P (공유 간선을 가진 빈 삼각형 쌍의 수) 계산
        for (int i = 0; i < n; i++) {
            Point A = P[i];
            Point[] V = new Point[n - 1];
            int idx = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                V[idx] = new Point();
                V[idx].x = P[j].x;
                V[idx].y = P[j].y;
                V[idx].id = j;
                V[idx].angle = Math.atan2(P[j].y - A.y, P[j].x - A.x);
                idx++;
            }
            Arrays.sort(V, (p1, p2) -> Double.compare(p1.angle, p2.angle));

            // 각도 Wrap-around 처리를 위한 배열 확장
            Point[] V2 = new Point[2 * n - 2];
            for (int j = 0; j < n - 1; j++) {
                V2[j] = V[j];
                V2[j + n - 1] = V[j];
            }

            for (int j = 0; j < n - 1; j++) {
                int B = V2[j].id;
                int best = j + 1;

                if (ccw(A, V2[j], V2[best]) > 0) {
                    emptyLeft[A.id][B]++;
                    for (int k = j + 2; k < 2 * n - 2; k++) {
                        // 180도를 넘어가면 반평면을 벗어난 것이므로 중단
                        if (ccw(A, V2[j], V2[k]) <= 0) break;

                        if (ccw(V2[j], V2[best], V2[k]) > 0) {
                            emptyLeft[A.id][B]++;
                            best = k;
                        }
                    }
                }
            }
        }

        long P_total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                P_total += emptyLeft[i][j] * emptyLeft[j][i];
            }
        }

        // 2. Q_convex (빈 볼록 사각형의 수) 계산
        long q_conv = 0;
        for (int i = 0; i < n; i++) {
            Point A = P[i];
            ArrayList<Point> rightPoints = new ArrayList<>();

            // A를 가장 왼쪽 꼭짓점으로 강제하기 위해 우측 반평면의 점만 추출
            for (int j = 0; j < n; j++) {
                if (P[j].x > A.x || (P[j].x == A.x && P[j].y > A.y)) {
                    Point p = new Point();
                    p.x = P[j].x;
                    p.y = P[j].y;
                    p.id = j;
                    p.angle = Math.atan2(p.y - A.y, p.x - A.x);
                    rightPoints.add(p);
                }
            }
            Collections.sort(rightPoints, (p1, p2) -> Double.compare(p1.angle, p2.angle));
            int m = rightPoints.size();
            if (m < 3) continue;

            boolean[][] valid = new boolean[m][m];
            for (int u = 0; u < m - 1; u++) {
                valid[u][u + 1] = true;
                int best = u + 1;
                for (int v = u + 2; v < m; v++) {
                    if (ccw(rightPoints.get(u), rightPoints.get(best), rightPoints.get(v)) > 0) {
                        valid[u][v] = true;
                        best = v;
                    }
                }
            }

            for (int v = 1; v < m - 1; v++) {
                long xv = rightPoints.get(v).x;
                long yv = rightPoints.get(v).y;
                for (int u = 0; u < v; u++) {
                    if (!valid[u][v]) continue;
                    long xu = rightPoints.get(u).x;
                    long yu = rightPoints.get(u).y;
                    long dx1 = xv - xu;
                    long dy1 = yv - yu;

                    for (int w = v + 1; w < m; w++) {
                        if (valid[v][w]) {
                            long xw = rightPoints.get(w).x;
                            long yw = rightPoints.get(w).y;
                            long dx2 = xw - xu;
                            long dy2 = yw - yu;

                            // 세 점이 CCW를 이루는지 확인 (볼록성 검증)
                            if (dx1 * dy2 > dy1 * dx2) {
                                q_conv++;
                            }
                        }
                    }
                }
            }
        }

        // 3. 최종 정답 출력
        System.out.println(P_total - q_conv);
    }

    // 외적(Cross Product) 연산: 부동소수점 오차 없는 정수론적 기하 판별
    static long ccw(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }
}