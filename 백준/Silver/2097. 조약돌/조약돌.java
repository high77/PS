import java.io.*;
import java.util.*;

public class Main {

       public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int sqrt = (int) Math.round(Math.sqrt(N));
        if (N<=4) ans.append(4);
        else {
            if (sqrt*sqrt<N) ans.append((sqrt-1)*2+sqrt*2);
            else ans.append((sqrt-1)*4);
        }
        System.out.print(ans);
    }
}
