import java.io.*;
import java.util.*;

public class Main {

    static HashMap<Long, Integer> map = new HashMap<>();
    static StringBuilder ans = new StringBuilder();

    static int stepA, stepB;
    static long meet;

    private static void trace(long x) {
        int step = 0;
        while (true) {
            Integer prev = map.put(x, step);
            if (prev != null) {
                stepA = prev;
                stepB = step;
                meet = x;
                return;
            }
            if (x == 1) return;
            x = (x % 2 == 0) ? x / 2 : x * 3 + 1;
            step++;
        }
    }

    private static void solve(long a, long b) {
        map.clear();
        trace(a);
        trace(b);
        ans.append(a).append(" needs ").append(stepA)
                .append(" steps, ").append(b).append(" needs ")
                .append(stepB).append(" steps, they meet at ")
                .append(meet).append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if (a == 0) break;
            solve(a, b);
        }

        System.out.print(ans);
    }
}
