import java.io.*;
import java.util.*;

public class Main {

    static int[] G_VALUES = {1, 2, 3, 3, 4, 10};
    static int[] S_VALUES = {1, 2, 2, 2, 3, 5, 10};

    static int getScore(String input, int[] values) {
        StringTokenizer st = new StringTokenizer(input);
        int score = 0;
        for (int i = 0; i < values.length; i++) {
            score += Integer.parseInt(st.nextToken()) * values[i];
        }
        return score;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int gScore = getScore(br.readLine(), G_VALUES);
            int sScore = getScore(br.readLine(), S_VALUES);

            String result = (gScore > sScore) ? "Good triumphs over Evil"
                    : (gScore < sScore) ? "Evil eradicates all trace of Good"
                    : "No victor on this battle field";

            ans.append("Battle ").append(i).append(": ").append(result).append("\n");
        }
        System.out.print(ans);
    }


}
