import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // 좌표 정렬과 캡슐화를 위한 선분 클래스
    static class Segment {
        long x1, y1, x2, y2;

        public Segment(long x1, long y1, long x2, long y2) {
            this.x1 = Math.min(x1, x2);
            this.y1 = Math.min(y1, y2);
            this.x2 = Math.max(x1, x2);
            this.y2 = Math.max(y1, y2);
        }
    }

    static List<Integer>[] adj;
    static int[] match;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();

        List<Segment> hor = new ArrayList<>();
        List<Segment> ver = new ArrayList<>();

        // 1. 수평선과 수직선 그룹 분리
        for (int i = 0; i < n; i++) {
            long x1 = sc.nextInt();
            long y1 = sc.nextInt();
            long x2 = sc.nextInt();
            long y2 = sc.nextInt();

            if (y1 == y2) {
                hor.add(new Segment(x1, y1, x2, y2));
            } else {
                ver.add(new Segment(x1, y1, x2, y2));
            }
        }

        int hSize = hor.size();
        int vSize = ver.size();

        // 2. 이분 그래프 간선 연결 (교차 판별)
        adj = new ArrayList[hSize];
        for (int i = 0; i < hSize; i++) {
            adj[i] = new ArrayList<>();
            Segment h = hor.get(i);

            for (int j = 0; j < vSize; j++) {
                Segment v = ver.get(j);
                // 수평선의 x구간 내에 수직선의 x좌표가 포함되고, 수직선의 y구간 내에 수평선의 y좌표가 포함되면 교차
                if (h.x1 <= v.x1 && v.x1 <= h.x2 && v.y1 <= h.y1 && h.y1 <= v.y2) {
                    adj[i].add(j);
                }
            }
        }

        // 3. 이분 매칭 수행
        match = new int[vSize];
        Arrays.fill(match, -1);
        int matchedCount = 0;

        for (int i = 0; i < hSize; i++) {
            visited = new boolean[vSize];
            if (dfs(i)) {
                matchedCount++;
            }
        }

        // 4. 쾨니그의 정리: 최대 독립 집합 = 전체 노드 수 - 최대 이분 매칭 수
        System.out.println(n - matchedCount);
    }

    // DFS 기반 이분 매칭 알고리즘
    static boolean dfs(int u) {
        for (int v : adj[u]) {
            if (visited[v]) continue;
            visited[v] = true;

            // 점유되지 않았거나, 기존 점유 노드가 다른 매칭을 찾을 수 있는 경우
            if (match[v] == -1 || dfs(match[v])) {
                match[v] = u;
                return true;
            }
        }
        return false;
    }

    // GC 오버헤드 최소화를 위한 커스텀 스캐너
    static class FastScanner {
        InputStream is;
        byte[] buf = new byte[1024 * 64];
        int head = 0, tail = 0;

        public FastScanner(InputStream is) {
            this.is = is;
        }

        public int nextInt() throws Exception {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
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