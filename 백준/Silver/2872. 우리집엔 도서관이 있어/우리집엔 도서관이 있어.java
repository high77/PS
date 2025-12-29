import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(br.readLine());
        int target = N, ans = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (list[i] == target) target--;
            else ans++;
        }

        System.out.println(ans);
    }
}