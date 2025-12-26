import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        String D = st.nextToken();

        boolean[] check = new boolean[B + 1];
        check[0] = check[1] = true;
        for (int i = 2; i*i <= B; i++) {
            if (check[i]) continue;
            for (int j = i*i; j <= B; j+=i) check[j] = true;
        }
        int ans = 0;

        for (int i=A; i<=B; i++) {
            if (check[i]) continue;
            if (String.valueOf(i).contains(D)) ans++;
        }

        System.out.println(ans);
    }
}
