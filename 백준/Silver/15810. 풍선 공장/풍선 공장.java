import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st= new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken()),
                 M = Integer.parseInt(st.nextToken());
        long[] list = new long[(int) N];

        st = new StringTokenizer(br.readLine());
        long min = Integer.MAX_VALUE;
        for (int n = 0; n < N; n++) {
            list[n] = Integer.parseInt(st.nextToken());
            min = Math.min(min, list[n]);
        }

        long l = 0, r = min * M;

        while(l +1 < r) {
            long center = (l + r)/2, balloon = 0;

            for (int n = 0; n < N; n++) balloon += (center / list[n]);

            if(balloon < M) l = center;
            else r = center;

        }

        System.out.println(r);
    }
}
