import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= K; i++) {
            int tmp = N*i, res =0;
            
            while (tmp!=0) {
                res*=10;
                res+=tmp%10;
                tmp/=10;
            }
            ans = Math.max(ans, res);
        }
        System.out.println(ans);
    }
}