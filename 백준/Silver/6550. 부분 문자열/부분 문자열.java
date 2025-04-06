import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        String input = "";
        while ((input = br.readLine()) != null && input.length()>0) {
            StringTokenizer st = new StringTokenizer(input);
            String s = st.nextToken(), t = st.nextToken();
            int idx = 0;
            boolean flag = false;
            for (char c : t.toCharArray()) {
                if (s.charAt(idx) == c) idx++;
                if (idx == s.length()) {
                    flag = true;
                    break;
                }
            }
            if (flag) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}