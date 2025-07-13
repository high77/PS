import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int[] dx = {0, 1, 0, -1},dy={1, 0, -1, 0};
        int T = Integer.parseInt(br.readLine());
        for (int tc=0; tc<T; tc++) {
            char[] S = br.readLine().toCharArray();
            int x=0,y=0;
            int d=0,minX=0,minY=0,maxX=0,maxY=0;
            for (char c : S) {
                if (c == 'F') {
                    x+=dx[d];
                    y+=dy[d];
                }
                else if (c == 'B') {
                    x-=dx[d];
                    y-=dy[d];
                }
                else if (c == 'L') d=(d+3)%4;
                else d=(d+1)%4;
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
            ans.append((maxX-minX)*(maxY-minY)).append("\n");
        }
        System.out.println(ans);
    }
}