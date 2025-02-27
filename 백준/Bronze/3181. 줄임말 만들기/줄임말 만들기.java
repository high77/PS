import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        ans.append(st.nextToken().toUpperCase().charAt(0));
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            if(str.equals("i")) continue;
            if(str.equals("pa")) continue;
            if(str.equals("te")) continue;
            if(str.equals("ni")) continue;
            if(str.equals("niti")) continue;
            if(str.equals("a")) continue;
            if(str.equals("ali")) continue;
            if(str.equals("nego")) continue;
            if(str.equals("no")) continue;
            if(str.equals("ili")) continue;
            ans.append(str.toUpperCase().charAt(0));
        }
        System.out.println(ans);
    }
}
