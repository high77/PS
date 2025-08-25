import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String prefix = st.nextToken();
        while (st.hasMoreTokens()) {
            ans.append(prefix);
            String s = st.nextToken();
            int e= 0;
            for (int i = s.length()-2; i >0; i--) {
                if (Character.isAlphabetic(s.charAt(i))) {
                    e = i;
                    break;
                }
                if (s.charAt(i) == ']') ans.append('[');
                else if (s.charAt(i)=='[') ans.append(']');
                else ans.append(s.charAt(i));
            }
            ans.append(" ");
            for (int i=0;i<=e;i++) ans.append(s.charAt(i));
            ans.append(';').append('\n');
        }
        System.out.println(ans);
    }
}