import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N*5+1][M*5+1];
        int[] res = new int[5];
        for (int i=0; i<N*5; i++) map[i] = br.readLine().toCharArray();
        for (int i=1;i<=N*5;i+=5) {
            for (int j=1;j<=M*5;j+=5) {
                int cnt = 0;
                for (int k=0; k<4; k++) {
                    if (map[i+k][j] == '*') cnt++;
                    else break;
                }
                res[cnt]++;
            }
        }
        for (int i=0;i<5;i++) ans.append(res[i]+" ");
        System.out.println(ans);

    }
}
