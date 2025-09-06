import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()),cnt =0;
        for (int i = N-1; i >0; i--) {
            cnt++;
            if(N%i==0) break;
        }

        System.out.println(cnt);
    }

}