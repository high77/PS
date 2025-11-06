import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()),m = Integer.parseInt(st.nextToken())
                    , k = Integer.parseInt(st.nextToken()), d= Integer.parseInt(st.nextToken());
            int res1 = n*((m*(m-1))/2)*k, res2 = m*m*(n*(n-1)/2);
            int tmp = res1 + res2;
            int res = d/tmp;
            ans.append(res==0?-1:res*tmp);
            ans.append("\n");
        }
        System.out.println(ans);
    }
}

