import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), ans =0;
        for (int i = 1; i <= N; i++) {
            if (N%i==0) ans += i;
        }
        ans= ans*5-24;
        System.out.println(ans);
    }
}
