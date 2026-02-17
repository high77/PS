import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int winA = 0;
        int winB = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int scoreA = Integer.parseInt(st.nextToken());
            int scoreB = Integer.parseInt(st.nextToken());

            if (scoreA > scoreB) {
                winA++;
            } else if (scoreB > scoreA) {
                winB++;
            }
        }

        // 결과 출력 (A가 이긴 횟수, B가 이긴 횟수 순서)
        System.out.println(winA + " " + winB);
    }
}