import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        long x, y;
        public Point(long x, long y) { this.x = x; this.y = y; }
    }

    // 선분 방정식 Ax + By = C 를 완벽히 정규화하여 저장 (중복 방지)
    static class Line {
        long a, b, c;
        public Line(long a, long b, long c) {
            long g = gcd(Math.abs(a), gcd(Math.abs(b), Math.abs(c)));
            if (g > 0) {
                a /= g; b /= g; c /= g;
            }
            // 부호 정규화 (같은 선을 다르게 인식하지 않도록)
            if (a < 0 || (a == 0 && b < 0)) {
                a = -a; b = -b; c = -c;
            }
            this.a = a; this.b = b; this.c = c;
        }
        @Override
        public boolean equals(Object o) {
            Line l = (Line) o;
            return a == l.a && b == l.b && c == l.c;
        }
        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }

    // 분수 좌표계 (x/d, y/d) 를 저장하는 클래스
    static class PointRat {
        long x, y, d;
        public PointRat(long x, long y, long d) {
            if (d < 0) { x = -x; y = -y; d = -d; }
            long g = gcd(Math.abs(x), gcd(Math.abs(y), Math.abs(d)));
            if (g > 0) {
                x /= g; y /= g; d /= g;
            }
            this.x = x; this.y = y; this.d = d;
        }
        @Override
        public boolean equals(Object o) {
            PointRat p = (PointRat) o;
            return x == p.x && y == p.y && d == p.d;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y, d);
        }
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lineStr = br.readLine();
        if (lineStr == null) return;
        int n = Integer.parseInt(lineStr.trim());

        Point[] pts = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pts[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        Set<PointRat> candidates = new HashSet<>();
        Set<Line> lines = new HashSet<>();

        // 1 & 2: 점 자신 (Type 1) 및 모든 두 점의 중점과 수직 이등분선 생성 (Type 2)
        for (int i = 0; i < n; i++) {
            candidates.add(new PointRat(pts[i].x, pts[i].y, 1)); // 점 자체
            for (int j = i + 1; j < n; j++) {
                candidates.add(new PointRat(pts[i].x + pts[j].x, pts[i].y + pts[j].y, 2)); // 중점

                long A = 2 * (pts[j].x - pts[i].x);
                long B = 2 * (pts[j].y - pts[i].y);
                long C = pts[j].x * pts[j].x - pts[i].x * pts[i].x + pts[j].y * pts[j].y - pts[i].y * pts[i].y;
                lines.add(new Line(A, B, C));
            }
        }

        // 3. 수직 이등분선들의 교점 생성 (Type 3)
        List<Line> lineList = new ArrayList<>(lines);
        for (int i = 0; i < lineList.size(); i++) {
            for (int j = i + 1; j < lineList.size(); j++) {
                Line l1 = lineList.get(i);
                Line l2 = lineList.get(j);

                long D = l1.a * l2.b - l2.a * l1.b; // 행렬식 (Determinant)
                if (D != 0) { // 평행하거나 일치하지 않고 한 점에서 만난다면
                    long X = l1.c * l2.b - l2.c * l1.b;
                    long Y = l1.a * l2.c - l2.a * l1.c;
                    candidates.add(new PointRat(X, Y, D));
                }
            }
        }

        int minUnique = n;
        long[] dists = new long[n]; // HashSet 대신 1차원 배열을 활용하여 성능 극대화

        // 탐색
        for (PointRat q : candidates) {
            int uniqueCount = 0;
            for (int i = 0; i < n; i++) {
                // 부동소수점 오차 없는 완벽한 정수 거리 계산
                long dx = q.x - q.d * pts[i].x;
                long dy = q.y - q.d * pts[i].y;
                long d2 = dx * dx + dy * dy;

                boolean dup = false;
                for (int k = 0; k < uniqueCount; k++) {
                    if (dists[k] == d2) {
                        dup = true;
                        break;
                    }
                }
                if (!dup) {
                    dists[uniqueCount++] = d2;
                    // 최적화: 이미 구한 최솟값보다 같거나 커지면 즉시 중단 (Early Break)
                    if (uniqueCount >= minUnique) break;
                }
            }
            if (uniqueCount < minUnique) {
                minUnique = uniqueCount;
            }
        }

        System.out.println(minUnique);
    }
}