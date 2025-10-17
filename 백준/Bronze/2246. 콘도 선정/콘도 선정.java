import java.io.*;
import java.util.*;

public class Main {
    static class Condo {
        int d, c;
        public Condo(int d, int c) {
            this.d = d;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Condo[] arr = new Condo[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Condo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Condo cur = arr[i];
            boolean chk = true;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (cur.c>arr[j].c && cur.d>=arr[j].d) {
                    chk = false;
                    break;
                }
                if (cur.d>arr[j].d && cur.c>=arr[j].c) {
                    chk = false;
                    break;
                }
            }
            if (chk) cnt++;
        }
        System.out.println(cnt);
    }
}
