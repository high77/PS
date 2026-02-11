import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String bestName = "";
        int maxScore = -1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            if (score > maxScore || (score == maxScore && name.compareTo(bestName) < 0)) {
                maxScore = score;
                bestName = name;
            }
        }
        System.out.println(bestName);
    }
}