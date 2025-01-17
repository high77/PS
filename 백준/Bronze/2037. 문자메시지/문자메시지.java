import java.io.*;
import java.util.*;

public class Main {

       public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] alpha = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5,6, 6, 6, 7, 7, 7, 7};
        int[] order = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4,1, 2, 3, 1, 2, 3, 4};
        int P = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());
        char[] S = br.readLine().toCharArray();
        int ans = order[S[0]-'A']*P;
        for (int i = 1; i < S.length; i++) {
            if (S[i] == ' ') ans+=P;
            else {
                if (S[i-1]!=' ' && alpha[S[i-1]-'A']==alpha[S[i]-'A']) ans+=W;
                ans+=order[S[i]-'A']*P;
            }
        }
        System.out.print(ans);
    }
}
