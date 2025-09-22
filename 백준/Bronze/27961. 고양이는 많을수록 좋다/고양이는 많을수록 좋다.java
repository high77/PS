import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N =Long.parseLong(br.readLine()),n=1;
        int ans = 1;
        while (N>n){
            ans++;
            n*=2;
        }
        System.out.println(N==0?0:ans);
    }

}
