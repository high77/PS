import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1], sum = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i-1]>arr[i]) sum[i]+=sum[i-1]+1;
            else sum[i]=sum[i-1];
        }
        int M = Integer.parseInt(br.readLine()), s,e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            ans.append(sum[e]-sum[s]).append("\n");
        }
        System.out.println(ans);
    }

}