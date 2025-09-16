import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = N+1;
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);
        for(int i=0;i<N;i++) {
            if (list[i]!=i+1) {
                ans = i+1;
                break;
            }
        }
        System.out.println(ans);
    }
}