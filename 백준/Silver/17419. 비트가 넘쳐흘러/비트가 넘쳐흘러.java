import java.util.StringTokenizer;
import java.io.*;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans =0;
        br.readLine();
        for (char c:br.readLine().toCharArray()) {
            if (c=='1') ans++;
        }
        System.out.println(ans);
    }


}