import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken())
                , res = 0;
        for(int h = 0; h <= N; h++) {
            for(int m = 0; m < 60; m++) {
                for(int s = 0; s < 60; s++) {
                    if( h % 10 == K || h / 10 == K || m % 10 == K || m / 10 == K || s % 10 == K || s / 10 == K ) res += 1;
                }
            }
        }
        System.out.println(res);
    }
}