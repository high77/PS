import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        long x, y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        long[] X = new long[n];
        long[] Y = new long[n];
        long[] D = new long[n];
        long[] U = new long[n];
        long[] V = new long[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Long.parseLong(st.nextToken());
            Y[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
            U[i] = X[i] + Y[i];
            V[i] = X[i] - Y[i];
        }

        // 1번 비콘을 기준으로 4개의 경계선(테두리)을 초기화
        List<long[]> line1 = new ArrayList<>(); line1.add(new long[]{V[0] - D[0], V[0] + D[0]});
        List<long[]> line2 = new ArrayList<>(); line2.add(new long[]{V[0] - D[0], V[0] + D[0]});
        List<long[]> line3 = new ArrayList<>(); line3.add(new long[]{U[0] - D[0], U[0] + D[0]});
        List<long[]> line4 = new ArrayList<>(); line4.add(new long[]{U[0] - D[0], U[0] + D[0]});

        // 나머지 비콘들과의 교집합 필터링
        for (int i = 1; i < n; i++) {
            line1 = intersectFixedU(line1, U[0] + D[0], U[i], V[i], D[i]);
            line2 = intersectFixedU(line2, U[0] - D[0], U[i], V[i], D[i]);
            line3 = intersectFixedV(line3, V[0] + D[0], U[i], V[i], D[i]);
            line4 = intersectFixedV(line4, V[0] - D[0], U[i], V[i], D[i]);
        }

        Set<Point> validPoints = new HashSet<>();
        boolean uncertain = false;

        if (collectPointsFixedU(line1, U[0] + D[0], validPoints) == -1) uncertain = true;
        if (collectPointsFixedU(line2, U[0] - D[0], validPoints) == -1) uncertain = true;
        if (collectPointsFixedV(line3, V[0] + D[0], validPoints) == -1) uncertain = true;
        if (collectPointsFixedV(line4, V[0] - D[0], validPoints) == -1) uncertain = true;

        StringBuilder sb = new StringBuilder();
        if (uncertain || validPoints.size() > 1) {
            sb.append("uncertain");
        } else if (validPoints.size() == 1) {
            Point p = validPoints.iterator().next();
            sb.append(p.x).append(" ").append(p.y);
        } else {
            sb.append("impossible");
        }

        System.out.println(sb.toString());
    }

    static List<long[]> intersectFixedU(List<long[]> intervals, long fixedU, long ui, long vi, long di) {
        List<long[]> next = new ArrayList<>();
        long dU = Math.abs(fixedU - ui);
        if (dU > di) return next;

        if (dU == di) {
            for (long[] interval : intervals) {
                long newA = Math.max(interval[0], vi - di);
                long newB = Math.min(interval[1], vi + di);
                if (newA <= newB) next.add(new long[]{newA, newB});
            }
        } else {
            long p1 = vi - di, p2 = vi + di;
            for (long[] interval : intervals) {
                if (interval[0] <= p1 && p1 <= interval[1]) next.add(new long[]{p1, p1});
                if (interval[0] <= p2 && p2 <= interval[1]) next.add(new long[]{p2, p2});
            }
        }
        return next;
    }

    static List<long[]> intersectFixedV(List<long[]> intervals, long fixedV, long ui, long vi, long di) {
        List<long[]> next = new ArrayList<>();
        long dV = Math.abs(fixedV - vi);
        if (dV > di) return next;

        if (dV == di) {
            for (long[] interval : intervals) {
                long newA = Math.max(interval[0], ui - di);
                long newB = Math.min(interval[1], ui + di);
                if (newA <= newB) next.add(new long[]{newA, newB});
            }
        } else {
            long p1 = ui - di, p2 = ui + di;
            for (long[] interval : intervals) {
                if (interval[0] <= p1 && p1 <= interval[1]) next.add(new long[]{p1, p1});
                if (interval[0] <= p2 && p2 <= interval[1]) next.add(new long[]{p2, p2});
            }
        }
        return next;
    }

    static boolean sameParity(long a, long b) {
        return Math.abs(a % 2) == Math.abs(b % 2);
    }

    static int collectPointsFixedU(List<long[]> intervals, long fixedU, Set<Point> validPoints) {
        for (long[] interval : intervals) {
            long start = interval[0], end = interval[1];
            if (!sameParity(start, fixedU)) start++;
            if (!sameParity(end, fixedU)) end--;

            if (start <= end) {
                long count = (end - start) / 2 + 1;
                if (count > 1) return -1;
                if (count == 1) validPoints.add(new Point((fixedU + start) / 2, (fixedU - start) / 2));
            }
        }
        return 0;
    }

    static int collectPointsFixedV(List<long[]> intervals, long fixedV, Set<Point> validPoints) {
        for (long[] interval : intervals) {
            long start = interval[0], end = interval[1];
            if (!sameParity(start, fixedV)) start++;
            if (!sameParity(end, fixedV)) end--;

            if (start <= end) {
                long count = (end - start) / 2 + 1;
                if (count > 1) return -1;
                if (count == 1) validPoints.add(new Point((start + fixedV) / 2, (start - fixedV) / 2));
            }
        }
        return 0;
    }
}