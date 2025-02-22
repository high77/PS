import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] picture = new int[100][100];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) -1, y1 = Integer.parseInt(st.nextToken()) -1
                    , x2 = Integer.parseInt(st.nextToken()) -1, y2 = Integer.parseInt(st.nextToken()) -1;
            for(int j = y1; j <= y2; j++) {
                for(int k = x1; k <= x2; k++) {
                    picture[j][k]++;
                }
            }


        }
        int cnt = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(picture[i][j] > M) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
