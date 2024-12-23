import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken())
                , B = Integer.parseInt(st.nextToken())
                , C = Integer.parseInt(st.nextToken())%2;
        int ans = C==1?A^B:A;
        System.out.println(ans);
    }
}
