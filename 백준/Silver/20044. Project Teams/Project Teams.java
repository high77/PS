import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())*2 , ans = Integer.MAX_VALUE
                ,list[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);

        for (int i = 0; i < N; i++) ans = Math.min(ans,list[i] + list[N - i - 1]);
        System.out.println(ans);
    }
}