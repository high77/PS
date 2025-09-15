import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T--> 0) {
            int N = Integer.parseInt(br.readLine()),min=Integer.MAX_VALUE,max= Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int a = Integer.parseInt(st.nextToken());
                if (a < min) min = a;
                if (a > max) max = a;
            }
            ans.append(min+" "+max+"\n");
        }
        System.out.println(ans);
    }
}