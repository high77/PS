import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        ans.append(Math.max(A+B,A-B)).append("\n").append(Math.min(A-B,A+B));

        System.out.println(ans);
    }
}