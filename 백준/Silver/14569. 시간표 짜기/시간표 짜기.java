import javax.xml.stream.FactoryConfigurationError;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] subject = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a<32) subject[i][0] |= (1<<a);
                else subject[i][1] |= (1<<a);
            }
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int[] bit = new int[2];
            for (int j = 0; j < p; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a<32) bit[0] |= (1<<a);
                else bit[1] |= (1<<a);
            }
            int res =0;
            for (int j = 0; j < N; j++) {
                boolean flag = true;
                for (int b = 0; b<2;b++){
                    if ((bit[b] & subject[j][b]) != subject[j][b]) flag = false;
                }
                if (flag) res++;
            }
            ans.append(res+"\n");
        }

        System.out.print(ans);
    }
}
