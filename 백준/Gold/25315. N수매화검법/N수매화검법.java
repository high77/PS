import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
    }

    static class Line {
        Point s, e;
        long w;
        Line(Point s, Point e, long w) { this.s = s; this.e = e; this.w = w; }
    }

    // CCW 알고리즘: 세 점의 방향성 확인
    static int ccw(Point a, Point b, Point c) {
        long res = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (res > 0) return 1;  // 반시계
        if (res < 0) return -1; // 시계
        return 0;               // 일직선
    }

    // 두 선분이 교차하는지 확인
    static boolean isIntersect(Line l1, Line l2) {
        int res1 = ccw(l1.s, l1.e, l2.s) * ccw(l1.s, l1.e, l2.e);
        int res2 = ccw(l2.s, l2.e, l1.s) * ccw(l2.s, l2.e, l1.e);
        // 문제 조건상 세 점이 일직선에 있는 경우는 없으므로 단순 비교
        return res1 < 0 && res2 < 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Line[] lines = new Line[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sx = Long.parseLong(st.nextToken());
            long sy = Long.parseLong(st.nextToken());
            long ex = Long.parseLong(st.nextToken());
            long ey = Long.parseLong(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            lines[i] = new Line(new Point(sx, sy), new Point(ex, ey), w);
        }

        long totalCost = 0;
        // 1. 모든 가중치의 기본 합 (m=0일 때의 최소 비용)
        for (int i = 0; i < N; i++) {
            totalCost += lines[i].w;
        }

        // 2. 교차하는 쌍에 대해 더 작은 가중치를 추가로 더함
        // (가중치가 큰 것을 먼저 행하면 작은 것만 추가 비용으로 남음)
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isIntersect(lines[i], lines[j])) {
                    totalCost += Math.min(lines[i].w, lines[j].w);
                }
            }
        }

        System.out.println(totalCost);
    }
}