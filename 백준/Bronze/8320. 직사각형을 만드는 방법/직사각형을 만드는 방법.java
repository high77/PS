import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int res =0;
        int N = Integer.parseInt(br.readLine());
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=i; j++) {
                if (i*j<=N) res++;
            }
        }
        System.out.println(res);
    }
}