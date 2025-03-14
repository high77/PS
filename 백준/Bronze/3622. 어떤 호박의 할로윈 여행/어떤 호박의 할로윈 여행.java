import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken())
                , a = Integer.parseInt(st.nextToken())
                , B = Integer.parseInt(st.nextToken())
                , b = Integer.parseInt(st.nextToken())
                , P = Integer.parseInt(st.nextToken());
        if (A > P || B > P) ans.append("No");
        else if (A + B <= P || a >= B || b >= A) ans.append("Yes");
        else ans.append("No");
        System.out.println(ans);

    }
}
