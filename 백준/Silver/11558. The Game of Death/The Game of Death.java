import java.io.*;

public class Main {

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = read();
        while (T-- > 0) {
            int N = read(), i;
            boolean flag = false;
            int[] list = new int[N+1];
            for (i = 1; i <= N; i++) list[i] = read();
            boolean[] visit = new boolean[N + 1];

            int cur = list[1], res = 1;
            while (true) {
                if (cur == N) {
                    ans.append(res).append("\n");
                    break;
                }
                if (visit[cur]) {
                    ans.append(0).append("\n");
                    break;
                }
                visit[cur] = true;

                cur = list[cur];
                res++;
            }
        }

        System.out.println(ans);
    }
}
