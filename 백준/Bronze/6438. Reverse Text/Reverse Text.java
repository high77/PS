import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N=Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = s.length()-1; j >= 0; j--) ans.append(s.charAt(j));
            ans.append('\n');
        }
        System.out.println(ans);
    }
}
