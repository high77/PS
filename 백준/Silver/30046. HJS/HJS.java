import java.io.*;

public class Main {
    static String P, Q, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        P = br.readLine();
        Q = br.readLine();
        R = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int h = 1; h <= 9; h++) {
            for (int j = 1; j <= 9; j++) {
                if (j == h) continue;
                for (int s = 1; s <= 9; s++) {
                    if (s == h || s == j) continue;

                    if (check(h, j, s)) {
                        sb.append("HJS! HJS! HJS!");
                        System.out.println(sb);
                        return;
                    }
                }
            }
        }
        System.out.println("Hmm...");
    }

    private static boolean check(int h, int j, int s) {
        int cmpPQ = compare(P, Q, h, j, s);
        if (cmpPQ >= 0) return false;
        int cmpQR = compare(Q, R, h, j, s);
        return cmpQR < 0;
    }

    private static int compare(String a, String b, int h, int j, int s) {
        for (int i = 0; i < a.length(); i++) {
            int da = (a.charAt(i) == 'H') ? h : (a.charAt(i) == 'J' ? j : s);
            int db = (b.charAt(i) == 'H') ? h : (b.charAt(i) == 'J' ? j : s);
            if (da != db) return da - db;
        }
        return 0;
    }
}
