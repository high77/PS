import java.io.InputStream;
import java.util.Arrays;

public class Main {
    static class Point {
        int x, y, id, rayId;
        Point(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

    static class Segment {
        Point a, b;
        Segment(Point a, Point b) {
            this.a = a;
            this.b = b;
        }
    }

    static Segment[] tree;
    static Point[] closestCandidate;

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int N = sc.nextInt();

        Point[] orig = new Point[N];
        Point[] sorted = new Point[N];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            orig[i] = new Point(x, y, i + 1);
            sorted[i] = orig[i];
        }

        // 1. 각도 기준 오름차순 정렬 (CCW)
        Arrays.sort(sorted, (p1, p2) -> {
            long c = cross(p1, p2);
            return c > 0 ? -1 : (c < 0 ? 1 : 0);
        });

        closestCandidate = new Point[N];
        int m = 0;

        // 2. 고유 광선(Ray) ID 부여 및 광선별 최우선 후보 선출
        sorted[0].rayId = 0;
        closestCandidate[0] = sorted[0];
        for (int i = 1; i < N; i++) {
            if (cross(sorted[i - 1], sorted[i]) != 0) {
                m++;
                closestCandidate[m] = sorted[i];
            } else {
                if (distSq(sorted[i]) < distSq(closestCandidate[m])) {
                    closestCandidate[m] = sorted[i];
                }
            }
            sorted[i].rayId = m;
        }
        int totalRays = m + 1;

        // 3. 선분 트리 생성 및 선분 삽입
        tree = new Segment[4 * totalRays];
        for (int i = 0; i < N; i++) {
            Point u = orig[i];
            Point v = orig[(i + 1) % N];
            int ru = u.rayId;
            int rv = v.rayId;

            if (ru == rv) continue; // 방사형 선분은 시야를 차단하지 않음
            if (ru > rv) {
                int temp = ru; ru = rv; rv = temp;
            }
            insertSeg(1, 0, totalRays - 1, ru, rv, new Segment(u, v));
        }

        // 4. 가시성 검증 및 정답 취합
        int[] ans = new int[N];
        int ansCount = 0;

        for (int k = 0; k < totalRays; k++) {
            if (!isBlocked(1, 0, totalRays - 1, k, closestCandidate[k])) {
                ans[ansCount++] = closestCandidate[k].id;
            }
        }

        Arrays.sort(ans, 0, ansCount);

        StringBuilder sb = new StringBuilder();
        sb.append(ansCount).append("\n");
        for (int i = 0; i < ansCount; i++) {
            sb.append(ans[i]).append(i == ansCount - 1 ? "" : " ");
        }
        System.out.println(sb.toString());
    }

    static void insertSeg(int node, int l, int r, int ql, int qr, Segment seg) {
        if (ql <= l && r <= qr) {
            if (tree[node] == null) {
                tree[node] = seg;
            } else if (isCloser(seg, tree[node])) {
                tree[node] = seg;
            }
            return;
        }
        int mid = (l + r) / 2;
        if (ql <= mid) insertSeg(node * 2, l, mid, ql, qr, seg);
        if (qr > mid) insertSeg(node * 2 + 1, mid + 1, r, ql, qr, seg);
    }

    static boolean isBlocked(int node, int l, int r, int targetRay, Point candidate) {
        if (tree[node] != null) {
            Segment seg = tree[node];
            if (seg.a != candidate && seg.b != candidate) {
                Point A = seg.a;
                Point B = seg.b;
                if (cross(A, B) < 0) { Point temp = A; A = B; B = temp; }
                if (ccw(A, B, candidate) < 0) return true; // 선분이 후보를 가림
            }
        }
        if (l == r) return false;

        int mid = (l + r) / 2;
        if (targetRay <= mid) return isBlocked(node * 2, l, mid, targetRay, candidate);
        else return isBlocked(node * 2 + 1, mid + 1, r, targetRay, candidate);
    }

    static boolean isCloser(Segment s1, Segment s2) {
        Point A = s1.a, B = s1.b;
        Point C = s2.a, D = s2.b;
        if (cross(A, B) < 0) { Point t = A; A = B; B = t; }
        if (cross(C, D) < 0) { Point t = C; C = D; D = t; }

        if (cross(A, C) == 0 && distSq(A) != distSq(C)) return distSq(A) < distSq(C);
        if (cross(A, D) == 0 && distSq(A) != distSq(D)) return distSq(A) < distSq(D);
        if (cross(B, C) == 0 && distSq(B) != distSq(C)) return distSq(B) < distSq(C);
        if (cross(B, D) == 0 && distSq(B) != distSq(D)) return distSq(B) < distSq(D);

        if (isStrictlyInside(C, A, B)) return ccw(A, B, C) < 0;
        if (isStrictlyInside(D, A, B)) return ccw(A, B, D) < 0;
        if (isStrictlyInside(A, C, D)) return ccw(C, D, A) > 0;
        if (isStrictlyInside(B, C, D)) return ccw(C, D, B) > 0;

        return false;
    }

    static long cross(Point p1, Point p2) {
        return (long) p1.x * p2.y - (long) p1.y * p2.x;
    }

    static long ccw(Point a, Point b, Point c) {
        return ((long) b.x - a.x) * (c.y - a.y) - ((long) b.y - a.y) * (c.x - a.x);
    }

    static long distSq(Point p) {
        return (long) p.x * p.x + (long) p.y * p.y;
    }

    static boolean isStrictlyInside(Point p, Point a, Point b) {
        return cross(a, p) > 0 && cross(p, b) > 0;
    }

    // GC 부하 방지용 메모리 최적화 커스텀 I/O 클래스
    static class FastScanner {
        InputStream is;
        byte[] buf = new byte[1024 * 64];
        int head = 0, tail = 0;

        public FastScanner(InputStream is) { this.is = is; }

        public int nextInt() throws Exception {
            int c = read();
            while (c <= 32) { if (c == -1) return -1; c = read(); }
            int res = 0;
            while (c > 32) { res = res * 10 + c - '0'; c = read(); }
            return res;
        }

        private int read() throws Exception {
            if (head >= tail) {
                head = 0;
                tail = is.read(buf, 0, buf.length);
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }
    }
}