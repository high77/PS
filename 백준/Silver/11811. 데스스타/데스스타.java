import java.util.StringTokenizer;
import java.io.*;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int bit = 0;
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (i==j) continue;
                bit |= n;
            }
            ans.append(bit+" ");
        }
        System.out.println(ans);
    }


}