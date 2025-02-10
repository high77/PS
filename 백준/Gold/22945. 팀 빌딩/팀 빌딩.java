import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        long ans = 0;
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ability = new int[N];
        for (int i = 0; i < N; i++) ability[i] = Integer.parseInt(st.nextToken());
        int s=0,e=N-1;
        while (s<e) {
            ans = Math.max(ans,(long) (e-s-1)*Math.min(ability[s],ability[e]));
            if (ability[s]<=ability[e]) s++;
            else e--;
        }
        System.out.print(ans);
    }
}
