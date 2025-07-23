import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        long ans =1;
        int N = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[1000001],visited = new boolean[1000001];
        check[0] =check[1]= true;
        for (int i=2;i<500001;i++) {
            if (check[i]) continue;
            for (int j=i*2;j<=1000000;j+=i) check[j] = true;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (!check[n]&&!visited[n]) {
                visited[n] = true;
                ans*=n;
            }
        }
        System.out.println(ans!=1?ans:-1);
    }
}