import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        int A=N,B=N;
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken()), y=Integer.parseInt(st.nextToken());
            if (A<=x || B<=y) continue;
            if (x*B<y*A) B=y;
            else A=x;
        }
        System.out.println(A*B);
    }
}
