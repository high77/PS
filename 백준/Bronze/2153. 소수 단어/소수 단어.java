import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        char[] s = br.readLine().toCharArray();
        int res =0;
        for (char c : s) {
            if (c >= 'A' && c <= 'Z') res+=c-'A'+27;
            else res+=c-'a'+1;
        }
        boolean[] check = new boolean[res+1];
        for (int i=2;i<=res;i++) {
            if (i*i>res) break;
            if (check[i]) continue;
            for (int j=i*2;j<=res;j+=i) check[j] = true;
        }
        if (check[res]) ans.append("It is not a prime word.");
        else ans.append("It is a prime word.");
        System.out.println(ans);
    }
}
