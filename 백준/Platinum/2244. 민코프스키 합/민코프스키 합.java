import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Point[] A = new Point[n];
        for (int i = 0; i < n; i++) A[i] = new Point(sc.nextLong(), sc.nextLong());

        Point[] B = new Point[m];
        for (int i = 0; i < m; i++) B[i] = new Point(sc.nextLong(), sc.nextLong());

        reorder(A);
        reorder(B);

        A = appendFirst(A);
        B = appendFirst(B);

        List<Point> sum = new ArrayList<>();
        sum.add(new Point(A[0].x + B[0].x, A[0].y + B[0].y));

        int i = 0, j = 0;
        // [핵심 수정] 인덱스 범위를 초과하지 않도록 분기 처리
        while (i < n || j < m) {
            Point last = sum.get(sum.size() - 1);

            if (i < n && j < m) {
                Point pA = new Point(A[i + 1].x - A[i].x, A[i + 1].y - A[i].y);
                Point pB = new Point(B[j + 1].x - B[j].x, B[j + 1].y - B[j].y);
                long cross = pA.x * pB.y - pA.y * pB.x;

                if (cross >= 0) {
                    sum.add(new Point(last.x + pA.x, last.y + pA.y));
                    i++;
                } else {
                    sum.add(new Point(last.x + pB.x, last.y + pB.y));
                    j++;
                }
            } else if (i < n) {
                Point pA = new Point(A[i + 1].x - A[i].x, A[i + 1].y - A[i].y);
                sum.add(new Point(last.x + pA.x, last.y + pA.y));
                i++;
            } else {
                Point pB = new Point(B[j + 1].x - B[j].x, B[j + 1].y - B[j].y);
                sum.add(new Point(last.x + pB.x, last.y + pB.y));
                j++;
            }
        }

        sum.remove(sum.size() - 1);

        List<Point> filtered = new ArrayList<>();
        int sz = sum.size();
        for (int k = 0; k < sz; k++) {
            Point p1 = sum.get((k - 1 + sz) % sz);
            Point p2 = sum.get(k);
            Point p3 = sum.get((k + 1) % sz);
            if (ccw(p1, p2, p3) != 0) {
                filtered.add(p2);
            }
        }

        int minIdx = 0;
        for (int k = 1; k < filtered.size(); k++) {
            Point p = filtered.get(k);
            Point min = filtered.get(minIdx);
            if (p.x < min.x || (p.x == min.x && p.y < min.y)) {
                minIdx = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(filtered.size()).append("\n");
        for (int k = 0; k < filtered.size(); k++) {
            Point p = filtered.get((minIdx + k) % filtered.size());
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
        System.out.print(sb);
    }

    static class Point {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
    }

    static void reorder(Point[] p) {
        int n = p.length;
        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (p[i].x < p[minIdx].x || (p[i].x == p[minIdx].x && p[i].y < p[minIdx].y)) {
                minIdx = i;
            }
        }
        Point[] temp = new Point[n];
        for (int i = 0; i < n; i++) temp[i] = p[(minIdx + i) % n];
        for (int i = 0; i < n; i++) p[i] = temp[i];
    }

    static Point[] appendFirst(Point[] p) {
        Point[] res = new Point[p.length + 1];
        for (int i = 0; i < p.length; i++) res[i] = p[i];
        res[p.length] = p[0];
        return res;
    }

    static long ccw(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    static class FastScanner {
        InputStream is;
        byte[] buf = new byte[1024 * 64];
        int head = 0, tail = 0;
        public FastScanner(InputStream is) { this.is = is; }
        public long nextLong() throws Exception {
            int c = read();
            while (c <= 32) { if (c == -1) return -1; c = read(); }
            long res = 0;
            while (c > 32) { res = res * 10 + c - '0'; c = read(); }
            return res;
        }
        public int nextInt() throws Exception { return (int) nextLong(); }
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