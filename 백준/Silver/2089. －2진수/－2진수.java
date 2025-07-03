import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        if(N == 0) ans.append(0);
        else{
            while (N != 1){
                ans.append(Math.abs(N % -2));

                N = (int)(Math.ceil((double)N/-2));
            }
            ans.append(N);
        }
        System.out.println(ans.reverse());
    }
}