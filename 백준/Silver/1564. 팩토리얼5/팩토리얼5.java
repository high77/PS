import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long n = 1, mod = (long)1e12;
        for(int i = 1; i <= N; i++){
            n *= i;
            while(n %10 == 0) n /=10;

            n %= mod;
        }

        String ans = Long.toString(n);
        System.out.println(ans.substring(ans.length()-5));
    }
}