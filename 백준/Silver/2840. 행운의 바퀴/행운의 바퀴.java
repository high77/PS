import java.io.*;
import java.util.*;

public class Main {

    public static   void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , K = Integer.parseInt(st.nextToken());
        char[] res = new char[N];
        boolean[] alpha = new boolean[26];
        Arrays.fill(res,'?');
        int idx = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char b = st.nextToken().charAt(0);
            idx = (N+idx-a%N)%N;
            if (res[idx]==b) continue;
            if (res[idx] != '?' || alpha[b-'A']) {
                System.out.println('!');
                return;
            }
            alpha[b-'A'] = true;
            res[idx] = b;
        }
        for (int i=0;i<N;i++) ans.append(res[(idx+i)%N]);
        System.out.println(ans);
    }


}