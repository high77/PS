import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String path = br.readLine();

        int[] start = new int[26], end = new int[26];
        Arrays.fill(start, -1);

        for (int i = 0; i < 52; i++) {
            int cow = path.charAt(i) - 'A';
            if (start[cow] == -1) start[cow] = i;
            else end[cow] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (start[i] < start[j] && start[j] < end[i] && end[i] < end[j]) ans++;
            }
        }

        System.out.println(ans);
    }
}