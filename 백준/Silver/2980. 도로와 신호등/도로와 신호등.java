import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken())
                , location =0, time = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken())
                    , R = Integer.parseInt(st.nextToken())
                    , G = Integer.parseInt(st.nextToken());
            time += D-location;
            location = D;

            int gap = time%(R+G);
            if (gap < R) time += R-gap;
        }

        time += M-location;

        System.out.println(time);
    }
}