import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken())
                , K = Integer.parseInt(st.nextToken());
        long ans =1;
        int quotient = S/K,remainder = S%K;
        for (int i = 0; i < K; i++) {
            if (i<remainder) ans*=(quotient+1);
            else ans*=quotient;
        }
        System.out.println(ans);
    }

}