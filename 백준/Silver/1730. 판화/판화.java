import java.io.*;
import java.util.*;

public class Main {

    static int upDown(char[][] arr,char c, int x, int y, int N){
        int nx = x;
        if (c=='D') nx++;
        else nx--;
        if (nx<0 || nx>=N) return x;

        if (arr[x][y]=='-' || arr[x][y]=='+') arr[x][y] = '+';
        else arr[x][y] = '|';

        if (arr[nx][y]=='-' ||arr[nx][y]=='+') arr[nx][y] = '+';
        else arr[nx][y] = '|';

        return nx;
    }

    static int leftRight(char[][] arr,char c, int x, int y, int N){
        int ny = y;
        if (c=='R') ny++;
        else ny--;
        if (ny<0 || ny>=N) return y;

        if (arr[x][y]=='|' || arr[x][y]=='+') arr[x][y] = '+';
        else arr[x][y] = '-';

        if (arr[x][ny]=='|' ||arr[x][ny]=='+') arr[x][ny] = '+';
        else arr[x][ny] = '-';

        return ny;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(arr[i], '.');
        char[] input = br.readLine().toCharArray();
        int x=0,y=0;
        for (char c : input) {
            if (c=='D' || c=='U') x = upDown(arr,c,x,y,N);
            else y = leftRight(arr,c,x,y,N);
        }
        for (char[] list : arr) {
            for (char c : list) {
                ans.append(c);
            }
            ans.append('\n');
        }
        System.out.print(ans);
    }
}
