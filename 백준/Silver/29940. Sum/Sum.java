import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0 ;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , S = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(br.readLine());
        int s =0, e=N-1;
        while (s < e) {
            int v = list[s] + list[e];
            if (v>S) e--;
            else {
                if (v==S) ans ++;
                s++;
            }
        }
        System.out.println(ans);
    }

}