import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    static boolean[] cycle;

    static int find(int x) {
        return p[x] == x ? x : (p[x] = find(p[x]));
    }

    static void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) cycle[pa] = true;
        else {
            p[pb] = pa;
            cycle[pa] |= cycle[pb];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            p = new int[n + 1];
            cycle = new boolean[n + 1];
            for (int i = 1; i <= n; i++) p[i] = i;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Set<Integer> roots = new HashSet<>();
            for (int i = 1; i <= n; i++) roots.add(find(i));

            int cnt = 0;
            for (int r : roots) if (!cycle[r]) cnt++;

            if (cnt == 0) System.out.printf("Case %d: No trees.\n", tc++);
            else if (cnt == 1) System.out.printf("Case %d: There is one tree.\n", tc++);
            else System.out.printf("Case %d: A forest of %d trees.\n", tc++, cnt);
        }
    }
}
