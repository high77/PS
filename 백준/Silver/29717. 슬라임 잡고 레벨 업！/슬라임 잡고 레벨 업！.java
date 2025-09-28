import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans =new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            long N = Integer.parseInt(br.readLine());

            long sum = N*(N+1)/2;

            long X = (long) Math.sqrt(sum);

            if (X*(X+1)>sum) X--;

            ans.append(X+1).append("\n");
        }
        System.out.println(ans);
    }
}
