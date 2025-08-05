import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();
        int[] dir = new int[4];
        int d= 0,x=0,y=0;
        for (char c : S) {
            if (c == 'R') d=(d+1)%4;
            else if (c == 'L') d=(d+3)%4;
            else {
                if (d==0) {
                    y--;
                    if (-y>dir[d]) dir[d]++;
                } else if (d==2) {
                    y++;
                    if (y>dir[d]) dir[d]++;
                }else if (d==1) {
                    x--;
                    if (-x>dir[d]) dir[d]++;
                }else {
                    x++;
                    if (x>dir[d]) dir[d]++;
                }
            }
        }
        char[][] res = new char[dir[0]+dir[2]+1][dir[1]+dir[3]+1];
        for (int i=0; i<dir[0]+dir[2]+1; i++) {
            Arrays.fill(res[i], '#');
        }
        int[] now = {dir[2],dir[1]};
        d=0;
        res[now[0]][now[1]] = '.';
        for (char c:S) {
            if (c == 'R') d=(d+1)%4;
            else if (c == 'L') d=(d+3)%4;
            else {
                if (d==0) now[0]++;
                else if (d==2) now[0]--;
                else if (d==1) now[1]--;
                else now[1]++;
                res[now[0]][now[1]]='.';
            }
        }
        for (int i=0; i<dir[0]+dir[2]+1; i++) {
            for (int j=0; j<dir[1]+dir[3]+1; j++) ans.append(res[i][j]);
            ans.append('\n');
        }

        System.out.println(ans);
    }
}
