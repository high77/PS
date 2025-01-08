import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken())
                , H = Integer.parseInt(st.nextToken())
                , X = Integer.parseInt(st.nextToken())
                , Y = Integer.parseInt(st.nextToken())
                , P = Integer.parseInt(st.nextToken())
                , ans =0, radius = H/2;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())
                    , y = Integer.parseInt(st.nextToken());
            if (x>=X && x<=X+W && y>=Y && y<=Y+H) ans++;
            else if (((X-x)*(X-x)+(Y+radius-y)*(Y+radius-y))<=radius*radius) ans++;
            else if (((X+W-x)*(X+W-x)+(Y+radius-y)*(Y+radius-y))<=radius*radius) ans++;
        }
        System.out.println(ans);
    }
}