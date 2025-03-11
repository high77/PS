import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int res = n;
            while (true) {
                if ((n&-n)==n) break;
                if (n%2==0) n/=2;
                else n=n*3+1;
                res = Math.max(res, n);
            }
            ans.append(res).append("\n");
        }
        System.out.println(ans);

    }
}
