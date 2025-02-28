import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            if (S.equals("P=NP")) ans.append("skipped");
            else {
                int a=0,b=0;
                for (int j = 0; j < S.length(); j++) {
                    if (S.charAt(j) == '+') {
                        a = Integer.parseInt(S.substring(0,j));
                        b = Integer.parseInt(S.substring(j+1,S.length()));
                        break;
                    }
                }
                ans.append(a+b);
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
