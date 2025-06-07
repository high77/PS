import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int L = Integer.parseInt(br.readLine())
                , N = Integer.parseInt(br.readLine()), max1 = 0,max2=0, ans1=0, ans2=0;
        boolean[] check = new boolean[L+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())
                    , b = Integer.parseInt(st.nextToken());
            int cnt = b-a-1;
            if (cnt > max1) {
                max1 = cnt;
                ans1 = i;
            }
            cnt = 0;
            for (int j = a; j <= b; j++) {
                if (check[j]) continue;
                cnt++;
                check[j] = true;
            }
            if (cnt > max2) {
                max2 = cnt;
                ans2 = i;
            }
        }
        ans.append(ans1+"\n"+ans2);
        System.out.println(ans);
    }
}