import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        int[][] res = new int[N][N];
        int[] dx = {0,0,1,-1,-1,-1,1,1},dy={1,-1,0,0,-1,1,-1,1};
        for (int i=0;i<N;i++) {
            arr[i] = br.readLine().toCharArray();
            for (int j=0;j<N;j++) {
                if (arr[i][j] != '.') {
                    res[i][j] = -1;
                    for (int d=0;d<8;d++){
                        int nx = i+dx[d], ny=j+dy[d];
                        if (nx<0 || ny <0 || nx>=N || ny>=N || res[nx][ny]==-1) continue;
                        res[nx][ny]+=arr[i][j]-'0';
                    }
                }
            }
        }
        for (int[] list:res){
            for (int n:list) {
                if (n<0) ans.append('*');
                else ans.append(n<10?n:"M");
            }
            ans.append("\n");
        }

        System.out.println(ans);
    }

}