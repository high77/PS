import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken())
                , C = Integer.parseInt(br.readLine());
        Integer[] list = new Integer[N];
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(br.readLine());
        int cost = A, calory = C, ans = C / A;

        Arrays.sort(list, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            cost += B;
            calory += list[i];
            int res = calory / cost;
            if (ans > res) break;
            else ans = res;
        }
        System.out.println(ans);
    }
}