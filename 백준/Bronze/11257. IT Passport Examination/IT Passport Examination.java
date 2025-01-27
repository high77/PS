import java.util.*;
import java.io.*;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken())
                    , a = Integer.parseInt(st.nextToken())
                    , b = Integer.parseInt(st.nextToken())
                    , c = Integer.parseInt(st.nextToken());
            boolean flag = false;
            if (a>10 && b>7 && c>=12 && a+b+c>=55) flag = true;
            ans.append(n+" "+(a+b+c)+" ");
            if (flag) ans.append("PASS");
            else ans.append("FAIL");
            ans.append("\n");
        }
        System.out.println(ans);

    }

}
