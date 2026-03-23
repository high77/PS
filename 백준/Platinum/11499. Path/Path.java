import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        long x, y;
        double dist;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            Point[] v = new Point[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                v[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            }

            // v0를 원점(0,0)으로 평행 이동시켜 계산을 단순화
            long X0 = v[0].x;
            long Y0 = v[0].y;
            for (int i = 0; i < n; i++) {
                v[i].x -= X0;
                v[i].y -= Y0;
            }

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            List<Point>[] queries = new ArrayList[n - 1];
            for (int i = 0; i < n - 1; i++) {
                queries[i] = new ArrayList<>();
            }

            double totalAns = 0;

            for (int q = 0; q < m; q++) {
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());

                if (k == 0) {
                    // 밑변(Base Segment) 위에 있는 점은 직선 거리가 곧 최단 거리
                    totalAns += d;
                } else {
                    Point vk = v[k];
                    Point vn = v[(k + 1) % n];
                    long qx = vk.x;
                    long qy = vk.y;

                    // 직교 다각형이므로 x, y 중 하나만 변함
                    if (vk.x == vn.x) {
                        if (vn.y > vk.y) qy += d;
                        else qy -= d;
                    } else {
                        if (vn.x > vk.x) qx += d;
                        else qx -= d;
                    }

                    int segIdx = n - 1 - k;
                    queries[segIdx].add(new Point(qx, qy));
                }
            }

            // 상단 경계를 왼쪽에서 오른쪽으로 훑기 위해 순서 재배치 (u_0 ~ u_n-1)
            Point[] u = new Point[n];
            u[0] = v[0];
            for (int i = 1; i < n; i++) {
                u[i] = v[n - i];
            }

            ArrayList<Point> stack = new ArrayList<>();
            stack.add(u[0]);
            u[0].dist = 0;

            for (int i = 0; i < n - 1; i++) {
                Point curr = u[i];
                Point next = u[i + 1];

                if (curr.x == next.x) { // 수직 선분
                    if (curr.y < next.y) { // 천장이 높아짐 (Rise)
                        addToStack(stack, curr);
                        totalAns += answerQueries(stack, queries[i]);
                    } else { // 천장이 낮아짐 (Drop)
                        totalAns += answerQueries(stack, queries[i]);
                        addToStack(stack, next);
                    }
                } else { // 수평 선분
                    totalAns += answerQueries(stack, queries[i]);
                }
            }
            sb.append(String.format("%.1f\n", totalAns));
        }
        System.out.print(sb);
    }

    // 하단 볼록 껍질 유지를 위해 CCW 판별 후 스택 갱신
    static void addToStack(ArrayList<Point> stack, Point R) {
        if (stack.get(stack.size() - 1).x == R.x && stack.get(stack.size() - 1).y == R.y) return;

        while (stack.size() >= 2) {
            Point A = stack.get(stack.size() - 2);
            Point B = stack.get(stack.size() - 1);
            if (ccw(A, B, R) <= 0) { // 기울기가 감소하거나 같으면 (우회전)
                stack.remove(stack.size() - 1);
            } else {
                break;
            }
        }
        Point parent = stack.get(stack.size() - 1);
        R.dist = parent.dist + dist(parent, R);
        stack.add(R);
    }

    // 이분 탐색으로 최단 거리(접점) 탐색
    static double answerQueries(ArrayList<Point> stack, List<Point> queries) {
        double sum = 0;
        for (Point Q : queries) {
            int low = 0, high = stack.size() - 1;
            while (low < high) {
                int mid = (low + high + 1) >>> 1;
                Point A = stack.get(mid - 1);
                Point B = stack.get(mid);

                if (ccw(A, B, Q) <= 0) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }
            Point parent = stack.get(low);
            sum += parent.dist + dist(parent, Q);
        }
        return sum;
    }

    // 외적(Cross Product)을 통한 방향 판별 (양수면 반시계 방향/좌회전)
    static long ccw(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    static double dist(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}