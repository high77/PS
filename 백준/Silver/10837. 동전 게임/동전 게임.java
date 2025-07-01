import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int K = Integer.parseInt(br.readLine()), C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()),n= Integer.parseInt(st.nextToken());
            if (n>m) {
                if (n-m-1>=K-n+1) ans.append(0);
                else ans.append(1);
            }
            else if (n<m) {
                if (m-n-1>K-m+1) ans.append(0);
                else ans.append(1);
            }
            else ans.append(1);
            ans.append("\n");

        }
        System.out.println(ans);

    }


}