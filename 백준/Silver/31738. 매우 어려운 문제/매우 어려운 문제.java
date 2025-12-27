import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long ans =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken())
                , M = Long.parseLong(st.nextToken());
         if (N>=M) {
             System.out.println(ans);
             return;
         }
         ans = 1;
         for (long i=N;i>=2;i--) {
             ans *=i;
             ans %=M;
         }

        System.out.println(ans);
    }
}
