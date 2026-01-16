import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String v = br.readLine();

        int uCount = 0, dpCount = 0;

        for (int i = 0; i < v.length(); i++) {
            char c = v.charAt(i);
            if (c == 'U' || c == 'C') uCount++;
            else dpCount++;
        }

        StringBuilder ans = new StringBuilder();
        boolean possible = false;

        if (uCount > (dpCount + 1) / 2) {
            ans.append('U');
            possible = true;
        }

        if (dpCount > 0) {
            ans.append("DP");
            possible = true;
        }

        if (!possible) System.out.println("C");
        else System.out.println(ans);
    }
}