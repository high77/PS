import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()), ans =0;
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);

        for (int k = 1; k<=N; k++) {
            int c = list[N-k];
            if (c>=k) ans = k;
        }
        System.out.println(ans);
    }
}