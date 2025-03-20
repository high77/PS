import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken()), ey = Integer.parseInt(st.nextToken());
        int x = 0, y = 0;
        long i = 1, s = 1;

        while (x != ex + ey) {
            s += i * 6;
            x++;
            i++;
        }

        if (ex == x && ey == y) {
            System.out.println(s);
            return;
        }

        while (ex != x && ey != y) {
            s++;
            x--;
            y++;
        }
        System.out.println(s - (i - 1) * 6);
    }
}
