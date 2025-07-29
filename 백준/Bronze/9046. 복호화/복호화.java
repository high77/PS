import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String S = br.readLine();
            int[] result = new int[26];
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z') result[S.charAt(i) - 'a']++;
            }

            int max = 0;
            for (int r : result) {
                if (r > max) max = r;
            }

            int cnt = 0;
            int ans = 0;
            for (int j = 0; j < 26; j++) {
                if (max == result[j]) {
                    cnt++;
                    ans = j;
                }
            }

            System.out.println(cnt == 1 ? (char) (ans + 'a') : "?");
        }
    }
}