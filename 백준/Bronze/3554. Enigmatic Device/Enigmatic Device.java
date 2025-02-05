import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken()),
                    l = Integer.parseInt(st.nextToken()) - 1,
                    r = Integer.parseInt(st.nextToken()) - 1;
            if (type == 1) {
                for (int j = l; j <= r; j++) list[j] = (list[j] * list[j]) % 2010;
            } else if (type == 2) {
                long sum = 0;
                for (int j = l; j <= r; j++) {
                    sum += list[j];
                }
                ans.append(sum).append("\n");
            }
        }

        System.out.print(ans);
    }
}
