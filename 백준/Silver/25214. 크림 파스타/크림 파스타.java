import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine()),max;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE,res = 0;
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp < min) min= tmp;
            else res = Math.max(res,tmp-min);
            ans.append(res).append(" ");
        }
        System.out.println(ans);
    }
}