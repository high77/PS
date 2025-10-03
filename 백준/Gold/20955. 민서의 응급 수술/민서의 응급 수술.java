import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int[] p;

    static int find(int a) {
        return p[a] < 0 ? a : (p[a] = find(p[a]));
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        if (p[a] > p[b]) { // a 크기 < b 크기 이면 swap
            int t = a; a = b; b = t;
        }
        p[a] += p[b];
        p[b] = a;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        p = new int[n+1];
        Arrays.fill(p, -1);

        int ans = 0;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (!union(u, v)) ans++;
        }
        for (int i = 1; i <= n; i++) if (p[i] < 0) ans++;
        System.out.println(ans-1);
    }
}
