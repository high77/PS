import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];

        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> LIS = new ArrayList<>();
        LIS.add(list[0]);
        for (int i = 1; i < N; i++) {
            int n = list[i];

            if (LIS.get(LIS.size() - 1) < n) LIS.add(n);
            else {
                int s = 0, e = LIS.size() - 1;
                while (s < e) {
                    int mid = (s + e) / 2;
                    if (LIS.get(mid) >= n) e = mid;
                    else s = mid + 1;
                }
                LIS.set(e, n);
            }
        }
        System.out.println(LIS.size());
    }
}