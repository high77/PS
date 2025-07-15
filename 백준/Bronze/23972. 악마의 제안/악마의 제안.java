import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        if (N==1) ans.append(-1);
        else {
            long res = (long) K * N /(N-1);
            res += K*N%(N-1)!=0?1:0;
            ans.append(res);
        }

        System.out.println(ans);


    }
}