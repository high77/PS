import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken())
                , C = Integer.parseInt(st.nextToken());
        char[][] pasture = new char[R][C];
        int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
        for (int i = 0; i < R; i++) pasture[i] = br.readLine().toCharArray();
        for (int i=0; i<R;i++){
            for (int j=0; j<C;j++){
                if (pasture[i][j] == 'S'){
                    for (int d=0; d<4; d++){
                        int ni = i+dx[d], nj = j+dy[d];
                        if (ni<0 || nj <0 || ni>=R || nj >=C) continue;
                        if (pasture[ni][nj] == 'W'){
                            System.out.println(0);
                            return;
                        }else if (pasture[ni][nj] == '.') pasture[ni][nj] = 'D';
                    }
                }
            }
        }
        ans.append(1+"\n");
        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                ans.append(pasture[i][j]);
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}