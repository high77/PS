import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[] levels = new int[N];

        long max = Integer.MAX_VALUE;
        long min = Integer.MAX_VALUE;


        for (int i = 0; i < N; i++){
            levels[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, levels[i]);
        }
        long answer = 0;
        while (min <= max) {
            long mid = (max + min) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (mid >= levels[i]) {
                    sum += mid - levels[i];
                }
            }
            if (K >= sum) {
                min = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
