import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] check = new boolean[100001];
        check[0] = check[1] = true;
        for (int i = 2; i < check.length; i++) {
            if (check[i]) continue;
            for (int j = i+i; j < check.length; j+=i) {
                check[j] = true;
            }
        }
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), ans =0;
        for (int i = A; i <=B; i++) {
            int n = i, res =0, tmp = 2;
            while(n!=1){
                if (n%tmp!=0) {
                    tmp++;
                    continue;
                }
                n/=tmp;
                res++;
            }
            ans += check[res] ? 0 : 1;
        }
        System.out.println(ans);
    }
}
