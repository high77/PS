import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input ;
        while (true) {
            input = br.readLine();
            if(input==null||input.isEmpty()) break;
            StringTokenizer st = new StringTokenizer(input);

            int N = Integer.parseInt(st.nextToken());

            if (N<2) System.out.println("Jolly");
            else {
                boolean[] check = new boolean[N];
                int cnt = N-1;
                int n = Integer.parseInt(st.nextToken()), tmp;
                for (int i = 1; i < N; i++) {
                    tmp = Integer.parseInt(st.nextToken());
                    int abs = Math.abs(tmp - n);
                    n=tmp;
                    if (abs>=N || check[abs]) break;
                    check[abs] = true;
                    cnt--;
                }
                if (cnt>0)System.out.println("Not jolly");
                else System.out.println("Jolly");

            }

        }
    }

}