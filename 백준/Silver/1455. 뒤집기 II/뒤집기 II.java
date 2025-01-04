import java.io.*;
import java.util.*;

public class Main {

    static void f(char[][] arr, int x,int y){
        for (int i=0;i<=x;i++){
            for (int j=0;j<=y;j++) arr[i][j] = arr[i][j]=='1'?'0':'1';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) arr[i] = br.readLine().toCharArray();
        for (int i =N-1; i >= 0; i--) {
            for (int j = M-1; j >= 0; j--) {
                if (arr[i][j]=='1') {
                    f(arr,i,j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}