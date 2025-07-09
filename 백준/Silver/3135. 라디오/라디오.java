import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken())
                , N = Integer.parseInt(br.readLine());
        int ans = Math.abs(A-B);

        for (int i = 0; i < N; i++) ans = Math.min(Math.abs(B-Integer.parseInt(br.readLine()))+1, ans);

        System.out.println(ans);
    }


}