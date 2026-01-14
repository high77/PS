import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        int cnt = 0, ans = -1;
        loop:
        for (int i = 1; i < N; i++) {
            int target = A[i], j = i - 1;
            while (j >= 0 && A[j] > target) {
                A[j + 1] = A[j];
                if (++cnt == K) { ans = A[j + 1]; break loop; }
                j--;
            }
            if (j + 1 != i) {
                A[j + 1] = target;
                if (++cnt == K) { ans = A[j + 1]; break loop; }
            }
        }
        System.out.println(ans);
    }
}