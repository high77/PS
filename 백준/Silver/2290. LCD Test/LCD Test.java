import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();
        char[][] lcd = new char[2 * s + 3][(s + 2) * n.length() + n.length() - 1];

        Set<Integer>[] seg = new HashSet[7];
        seg[0] = new HashSet<>(Arrays.asList(2, 3, 5, 6, 7, 8, 9, 0));
        seg[1] = new HashSet<>(Arrays.asList(4, 5, 6, 8, 9, 0));
        seg[2] = new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8, 9, 0));
        seg[3] = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 8, 9));
        seg[4] = new HashSet<>(Arrays.asList(2, 6, 8, 0));
        seg[5] = new HashSet<>(Arrays.asList(1, 3, 4, 5, 6, 7, 8, 9, 0));
        seg[6] = new HashSet<>(Arrays.asList(2, 3, 5, 6, 8, 9, 0));

        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            for (int j = 0; j < 7; j++) {
                if (seg[j].contains(num)) fill(lcd, s, i, j);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < lcd.length; i++) {
            for (int j = 0; j < lcd[0].length; j++) ans.append(lcd[i][j] == '\u0000' ? ' ' : lcd[i][j]);
            ans.append('\n');
        }
        System.out.print(ans);
    }

    private static void fill(char[][] lcd, int s, int idx, int seg) {
        int base = (s + 3) * idx;
        if (seg == 0)
            for (int i = 0; i < s; i++) lcd[0][base + 1 + i] = '-';
        else if (seg == 3)
            for (int i = 0; i < s; i++) lcd[s + 1][base + 1 + i] = '-';
        else if (seg == 6)
            for (int i = 0; i < s; i++) lcd[2 * s + 2][base + 1 + i] = '-';
        else if (seg == 1)
            for (int i = 0; i < s; i++) lcd[i + 1][base] = '|';
        else if (seg == 4)
            for (int i = 0; i < s; i++) lcd[s + 2 + i][base] = '|';
        else if (seg == 2)
            for (int i = 0; i < s; i++) lcd[i + 1][base + s + 1] = '|';
        else if (seg == 5)
            for (int i = 0; i < s; i++) lcd[s + 2 + i][base + s + 1] = '|';
    }
}
