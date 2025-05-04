import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[100001];
        for (int i = 2; i < 101; i++) {
            if (check[i]) continue;
            for (int j = i+i; j <=100000; j+=i) check[j] = true;
        }

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int i = 2,cnt =0;
            while (N>1) {
                if (!check[i]) {
                    if (N%i!=0) {
                        if (cnt>0) ans.append(i+" "+cnt+"\n");
                        i++;
                        cnt =0;
                    }
                    else {
                        N/=i;
                        cnt++;
                    }
                }else i++;
            }
            if (cnt>0) ans.append(i+" "+cnt+"\n");
        }

        System.out.println(ans);
    }
}