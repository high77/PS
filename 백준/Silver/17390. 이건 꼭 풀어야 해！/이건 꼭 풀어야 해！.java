import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] list = new int[N],sum = new int[N+1];

        for(int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(list);

        for(int i = 1; i <= N; i++) sum[i] = sum[i-1] + list[i-1];


        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());

            ans.append(sum[R]-sum[L-1]+"\n");
        }

        System.out.println(ans);
    }
}