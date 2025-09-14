import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long R = Long.parseLong(st.nextToken())
                , C = Long.parseLong(st.nextToken())
                , N = Long.parseLong(st.nextToken());
        long a = R/N, b =C/N;
        a+=R%N==0?0:1;
        b+=C%N==0?0:1;

        System.out.println(a*b);
    }
}