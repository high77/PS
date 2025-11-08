import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        Integer[] list = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list,Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < K; i++) ans+= list[i]-i;
        System.out.println(ans);
    }
}

