import java.io.*;
import java.util.*;

public class Main {
    static int[][] room = new int[7][2];
    static int ans = 0, K;
    static void assign(int s,int y){
        room[y][s]++;
        if (room[y][s]==K) room[y][s]=0;
        if (room[y][s]==1) ans++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())
                    , y = Integer.parseInt(st.nextToken());
            if (y<3) assign(0, 0);
            else if (y<5) assign(s, 1);
            else assign(s,2);
        }
        System.out.println(ans);
    }
}