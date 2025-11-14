import java.io.*;
import java.util.*;

public class Main {

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = read();

        int[] diff = new int[10002];

        for (int i = 0; i < N; i++) {
            int x = read(), y = read();
            if (x > y) { int t = x; x = y; y = t; }

            diff[x]++;   
            diff[y]--;   
        }

        int ans = 0, active = 0;

        for (int i = 1; i <= 10000; i++) {
            active += diff[i]; 
            if (active > 0) ans++;
        }

        System.out.println(ans);
    }
}
