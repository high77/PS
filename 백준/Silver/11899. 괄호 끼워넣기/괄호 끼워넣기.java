import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        int cnt =0,ans=0;
        for (char c : S) {
            if (c==')'){
                if (cnt>0) cnt--;
                else ans++;
            }else cnt++;
        }
        ans +=cnt;
        System.out.println(ans);
    }
}