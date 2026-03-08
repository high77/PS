import java.io.*;
import java.util.*;

public class Main {
    static class Circle {
        double x, y, r;
        Circle(double x, double y, double r) { this.x = x; this.y = y; this.r = r; }
    }

    static class InterPoint {
        double x, y;
        int id;
        InterPoint(double x, double y, int id) { this.x = x; this.y = y; this.id = id; }
    }

    static class Arc {
        int index, startId, endId;
        double I; // 선적분 값 (Signed Area)
    }

    static class Event implements Comparable<Event> {
        double angle;
        int pointId;
        Event(double a, int id) { this.angle = a; this.pointId = id; }
        public int compareTo(Event o) { return Double.compare(this.angle, o.angle); }
    }

    static Map<String, List<InterPoint>> interMap;
    static int pointCounter;

    static int getPointId(int c1, int c2, double x, double y) {
        if (c1 > c2) { int tmp = c1; c1 = c2; c2 = tmp; }
        String key = c1 + "_" + c2;
        interMap.putIfAbsent(key, new ArrayList<>());
        for (InterPoint p : interMap.get(key)) {
            if (Math.abs(p.x - x) < 1e-3 && Math.abs(p.y - y) < 1e-3) return p.id;
        }
        InterPoint p = new InterPoint(x, y, ++pointCounter);
        interMap.get(key).add(p);
        return p.id;
    }

    static double normalize(double a) {
        while (a < 0) a += 2 * Math.PI;
        while (a >= 2 * Math.PI) a -= 2 * Math.PI;
        return a;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) break;

            Circle[] c = new Circle[n];
            for (int i = 0; i < n; i++) {
                c[i] = new Circle(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            }

            interMap = new HashMap<>();
            pointCounter = 0;
            List<Arc> arcs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<Event> events = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    double dx = c[j].x - c[i].x;
                    double dy = c[j].y - c[i].y;
                    double d2 = dx * dx + dy * dy;
                    double d = Math.sqrt(d2);

                    if (d < c[i].r + c[j].r && d > Math.abs(c[i].r - c[j].r)) {
                        double A = Math.atan2(dy, dx);
                        double B = Math.acos((c[i].r * c[i].r + d2 - c[j].r * c[j].r) / (2 * c[i].r * d));

                        double a1 = normalize(A - B);
                        int id1 = getPointId(i, j, c[i].x + c[i].r * Math.cos(a1), c[i].y + c[i].r * Math.sin(a1));
                        events.add(new Event(a1, id1));

                        double a2 = normalize(A + B);
                        int id2 = getPointId(i, j, c[i].x + c[i].r * Math.cos(a2), c[i].y + c[i].r * Math.sin(a2));
                        events.add(new Event(a2, id2));
                    }
                }

                if (events.isEmpty()) continue; // 교점 없는 원은 구멍(음수면적)을 만들 수 없으므로 무시

                Collections.sort(events);
                int K = events.size();

                for (int m = 0; m < K; m++) {
                    Event e1 = events.get(m);
                    Event e2 = events.get((m + 1) % K);

                    double alpha = e1.angle;
                    double beta = e2.angle;
                    if (beta <= alpha) beta += 2 * Math.PI; // 각도 연속성 보장

                    double mid = (alpha + beta) / 2;
                    double mx = c[i].x + c[i].r * Math.cos(mid);
                    double my = c[i].y + c[i].r * Math.sin(mid);

                    boolean isBoundary = true;
                    for (int j = 0; j < n; j++) {
                        if (i == j) continue;
                        double dist2 = (mx - c[j].x) * (mx - c[j].x) + (my - c[j].y) * (my - c[j].y);
                        if (dist2 < c[j].r * c[j].r - 1e-7) { // 잉크에 덮임
                            isBoundary = false;
                            break;
                        }
                    }

                    if (isBoundary) {
                        Arc arc = new Arc();
                        arc.index = arcs.size();
                        arc.startId = e1.pointId;
                        arc.endId = e2.pointId;
                        // 그린 정리 적분 공식
                        arc.I = c[i].r * c[i].x * (Math.sin(beta) - Math.sin(alpha))
                                - c[i].r * c[i].y * (Math.cos(beta) - Math.cos(alpha))
                                + c[i].r * c[i].r * (beta - alpha);
                        arcs.add(arc);
                    }
                }
            }

            Arc[] nextArc = new Arc[pointCounter + 1];
            for (Arc a : arcs) nextArc[a.startId] = a;

            boolean[] visited = new boolean[arcs.size()];
            int numInnerLoops = 0;

            for (int i = 0; i < arcs.size(); i++) {
                if (visited[i]) continue;
                double sumArea = 0;
                Arc curr = arcs.get(i);

                while (true) {
                    visited[curr.index] = true;
                    sumArea += curr.I;
                    curr = nextArc[curr.endId];
                    if (curr == null || visited[curr.index]) break;
                }

                if (sumArea < -1e-5) numInnerLoops++; // 음수 면적 = 구멍
            }

            System.out.println(1 + numInnerLoops);
        }
    }
}