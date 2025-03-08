import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , C = Integer.parseInt(st.nextToken());
        boolean[] check  = new boolean[C + 1];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            for (int j=a;j<=C;j+=a) check[j] = true;
        }
        for (int i=1;i<=C;i++) ans+=check[i] ? 1 : 0;
        System.out.println(ans);
    }
}
