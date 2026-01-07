import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N, d, min = Long.MAX_VALUE;
    static boolean[] u = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        d = Long.parseLong(st.nextToken());

        bt(0, 0);
        System.out.println(min == Long.MAX_VALUE ? -1 : min);
    }

    static void bt(int len, long val) {
        if (len == d) {
            if (val > N) min = Math.min(min, val);
            return;
        }

        for (int i = 0; i < d; i++) {
            if ((len == 0 && i == 0) || u[i]) continue;
            u[i] = true;
            bt(len + 1, val * d + i); 
            u[i] = false;
        }
    }
}