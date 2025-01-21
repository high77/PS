import java.io.*;
import java.util.*;

public class Main {
    static int N,M,ans;
    static char[][] arr;

    static void f(int x,int y, int dx,int dy, int curV){
        int nx = x+dx,ny = y+dy;
        if (Math.sqrt(curV)%1==0) ans = Math.max(ans,curV);
        if ((nx<0 || ny<0 || nx>=N || ny>=M) || (dx==0 && dy==0)) return;
        f(nx,ny,dx,dy,curV*10+(arr[nx][ny]-'0'));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        ans = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for (int i = 0; i < N; i++) arr[i] = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int dx = 0; dx < N; dx++) {
                    for (int dy = 0; dy < M; dy++) {
                        f(i,j,dx,dy,arr[i][j]-'0');
                        f(i,j,-dx,dy,arr[i][j]-'0');
                        f(i,j,dx,-dy,arr[i][j]-'0');
                        f(i,j,-dx,-dy,arr[i][j]-'0');
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
