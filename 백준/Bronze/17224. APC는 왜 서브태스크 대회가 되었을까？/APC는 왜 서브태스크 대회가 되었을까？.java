import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , L = Integer.parseInt(st.nextToken())
                , K = Integer.parseInt(st.nextToken()), ans =0;

        int[][] arr = new int[N][2];
        boolean[] visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (K>0) {
                if (arr[i][1] <= L) {
                    ans += 140;
                    K--;
                    visit[i] = true;
                }
            }else break;
        }
        for (int i = 0; i < N; i++) {
            if (K>0) {
                if (!visit[i] &&arr[i][0] <= L) {
                    ans += 100;
                    K--;
                }
            }else break;
        }


        System.out.println(ans);
    }
}
