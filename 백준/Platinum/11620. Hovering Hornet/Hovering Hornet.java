import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Point> box = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            box.add(new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
        }

        double vTop = 100.0;
        // 각 방향 반평면 방정식 (Ax + By + C > 0) 을 만족하는 영역 클리핑
        double vEast = 5.0 * getClippedArea(box, 1, 0, -0.5);   // x > 0.5
        double vWest = 5.0 * getClippedArea(box, -1, 0, -0.5);  // x < -0.5
        double vNorth = 5.0 * getClippedArea(box, 0, 1, -0.5);  // y > 0.5
        double vSouth = 5.0 * getClippedArea(box, 0, -1, -0.5); // y < -0.5

        // 기댓값 계산 (가용 공간 체적 = 124)
        double expected = (5 * vTop + 3 * vEast + 4 * vWest + 6 * vNorth + 1 * vSouth) / 124.0;

        System.out.printf("%.10f\n", expected);
    }

    // Sutherland-Hodgman 알고리즘과 신발끈 공식을 결합한 교집합 넓이 산출
    static double getClippedArea(List<Point> poly, double A, double B, double C) {
        List<Point> res = new ArrayList<>();
        int n = poly.size();

        for (int i = 0; i < n; i++) {
            Point prev = poly.get((i - 1 + n) % n);
            Point curr = poly.get(i);

            double d1 = A * prev.x + B * prev.y + C;
            double d2 = A * curr.x + B * curr.y + C;

            if (d1 > 0 && d2 > 0) {
                res.add(curr);
            } else if (d1 > 0 && d2 <= 0) {
                res.add(intersect(prev, curr, A, B, C));
            } else if (d1 <= 0 && d2 > 0) {
                res.add(intersect(prev, curr, A, B, C));
                res.add(curr);
            }
        }

        double area = 0;
        for (int i = 0; i < res.size(); i++) {
            Point p1 = res.get(i);
            Point p2 = res.get((i + 1) % res.size());
            area += (p1.x * p2.y - p2.x * p1.y);
        }
        return Math.abs(area) / 2.0;
    }

    // 선분과 반평면 경계선의 교점 반환
    static Point intersect(Point p1, Point p2, double A, double B, double C) {
        double denom = A * (p1.x - p2.x) + B * (p1.y - p2.y);
        if (Math.abs(denom) < 1e-9) {
            return new Point(p1.x, p1.y);
        }
        double t = (A * p1.x + B * p1.y + C) / denom;
        return new Point(p1.x + t * (p2.x - p1.x), p1.y + t * (p2.y - p1.y));
    }
}