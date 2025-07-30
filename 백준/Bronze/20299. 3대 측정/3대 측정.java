import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken())
                ,K = Integer.parseInt(st.nextToken())
                ,L = Integer.parseInt(st.nextToken());

        List<Integer> selectedMembers = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] scores = new int[3];
            int sum = 0;
            boolean isValid = true;

            for (int j = 0; j < 3; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
                sum += scores[j];
                if (scores[j] < L) isValid = false;
            }

            if (isValid && sum >= K) {
                cnt++;
                for (int score : scores) selectedMembers.add(score);
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(cnt).append('\n');
        for (int i = 0; i < selectedMembers.size(); i++) {
            ans.append(selectedMembers.get(i));
            if (i != selectedMembers.size() - 1) ans.append(' ');
        }

        System.out.println(ans);
    }
}
