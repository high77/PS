import java.io.*;
import java.util.*;

public class Main {

    static int f(ArrayList<Integer> list, int N, int M, char[][] lamp){
        int res = 0;

        for (int j : list){
            for (int i=0;i<N;i++) lamp[i][j] = lamp[i][j]=='0'?'1':'0';
        }

        for (int i=0;i<N;i++){
            int cnt =0;
            for (int j=0;j<M;j++){
                if (lamp[i][j]=='0') break;
                cnt++;
            }
            if (cnt==M) res++;
        }

        for (int j : list){
            for (int i=0;i<N;i++) lamp[i][j] = lamp[i][j]=='0'?'1':'0';
        }

        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken()), ans = 0;
        char[][] lamp = new char[N][M];
        for (int i = 0; i < N; i++) lamp[i] = br.readLine().toCharArray();
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                if (lamp[i][j] == '0') list.add(j);
            }
            if (list.size()>K || (K-list.size())%2==1) continue;
            ans = Math.max(ans, f(list, N, M, lamp));
        }
        System.out.println(ans);
    }
}