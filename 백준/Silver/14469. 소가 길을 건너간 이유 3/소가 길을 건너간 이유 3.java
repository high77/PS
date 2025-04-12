import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int ans = 0, arr[][] = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < N; i++) {
            if (ans< arr[i][0]) ans = arr[i][0]+arr[i][1];
            else ans += arr[i][1];
        }
        System.out.println(ans);
    }
}