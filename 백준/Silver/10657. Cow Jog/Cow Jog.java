import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st ;
        int[][] cows = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        int groups = 1;
        int slowestSpeed = cows[N - 1][1];

        for (int i = N - 2; i >= 0; i--) {
            if (cows[i][1] <= slowestSpeed) {
                groups++;
                slowestSpeed = cows[i][1];
            }
        }

        System.out.println(groups);
    }
}