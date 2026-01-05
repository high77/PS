import java.io.*;
import java.util.*;

public class Main {
    static boolean hasDigit(int num, int digit) {
        while (num > 0) {
            if (num % 10 == digit) return true;
            num /= 10;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= 9; i++) q.add(i);

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            if (curr > 1000000000) continue;

            for (int i = 0; i <= 9; i++) {
                if (!hasDigit(curr, i)) {
                    q.add(curr * 10 + i);
                }
            }
            if (res.size() >= 1000000) break;
        }

        while (true){
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            ans.append(res.get(N - 1)).append("\n");

        }

        System.out.println(ans);
    }
}