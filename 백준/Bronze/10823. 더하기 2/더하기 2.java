import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder();
        int ans =0;
        String str;
        while ((str = br.readLine()) != null) s.append(str);
        StringTokenizer st = new StringTokenizer(s.toString(),",");
        while (st.hasMoreTokens()) ans += Integer.parseInt(st.nextToken());

        System.out.println(ans);
    }
}