import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()),
                    b = Integer.parseInt(st.nextToken());
            char[] S = br.readLine().toCharArray();
            int l = S.length;

            for(int i=0; i<l; i++) {
                int x = S[i] - 'A';
                S[i] = (char)(((a * x + b) % 26) + 'A');
            }
            ans.append(S).append("\n");
        }
        System.out.println(ans);
    }
}
