import java.io.*;
import java.util.*;

public class Main {
    static class Vector {
        long x, y;
        Vector(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] pts = new long[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pts[i][0] = Long.parseLong(st.nextToken());
            pts[i][1] = Long.parseLong(st.nextToken());
        }

        Vector[] vecs = new Vector[2 * N];
        for (int i = 0; i < N; i++) {
            long dx = pts[(i + 1) % N][0] - pts[i][0];
            long dy = pts[(i + 1) % N][1] - pts[i][1];
            vecs[i] = new Vector(dx, dy);
            vecs[i + N] = vecs[i];
        }

        long totalTriples = (long) N * (N - 1) * (N - 2) / 6;
        long badTriples = 0;

        int j = 0;
        for (int i = 0; i < N; i++) {
            if (j <= i) j = i + 1;

            while (j < i + N && isWithin180(vecs[i], vecs[j])) {
                j++;
            }

            long count = j - i - 1;
            if (count >= 2) {
                badTriples += count * (count - 1) / 2;
            }
        }

        System.out.println(totalTriples - badTriples);
    }

    static boolean isWithin180(Vector v1, Vector v2) {
        long cross = v1.x * v2.y - v1.y * v2.x;
        if (cross > 0) return true;
        if (cross < 0) return false;
        long dot = v1.x * v2.x + v1.y * v2.y;
        return dot < 0;
    }
}