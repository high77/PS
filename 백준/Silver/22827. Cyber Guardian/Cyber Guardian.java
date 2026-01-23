import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) continue;
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            String[][] r = new String[n][3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                r[i] = new String[]{st.nextToken(), st.nextToken(), st.nextToken()};
            }

            List<String> res = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String p = br.readLine();
                st = new StringTokenizer(p);
                String src = st.nextToken(), dst = st.nextToken();
                boolean ok = false;
                for (int j = n - 1; j >= 0; j--) {
                    if (match(r[j][1], src) && match(r[j][2], dst)) {
                        ok = r[j][0].equals("permit");
                        break;
                    }
                }
                if (ok) res.add(p);
            }
            sb.append(res.size()).append("\n");
            for (String s : res) sb.append(s).append("\n");
        }
        System.out.print(sb);
    }

    static boolean match(String p, String a) {
        for (int i = 0; i < 8; i++)
            if (p.charAt(i) != '?' && p.charAt(i) != a.charAt(i)) return false;
        return true;
    }
}