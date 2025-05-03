import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken());

        boolean flag = true;

        for (int i = 0; i < M; i++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int tmp = 200_001;
            for (int j = 0; j < K; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a > tmp) flag = false;
                tmp = a;
            }
        }


        if (flag)  System.out.println("Yes");
        else System.out.println("No");
    }
}