import java.io.*;
import java.util.Arrays;

public class Main {

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = read();
        int[] check = new int[40001];
        check[0] = -1;
        for (int i = 1; i <= N; i++) {
            int n = read();
            for (int j = 40000; j >= 0; j--) {
                if (j+n<=40000 && check[j]!=0 && check[j]!=i && check[j+n]==0) check[j+n] = i;
                int tmp = Math.abs(j-n);
                if (check[j]!=0 && check[j]!=i && check[tmp]==0) check[tmp] = i;
            }
        }

        int M = read();
        for (int i = 0; i <M; i++) {
            if (check[read()]!=0) ans.append("Y");
            else ans.append("N");
            if (i!=M-1) ans.append(" ");
        }
        System.out.println(ans);
    }
}
