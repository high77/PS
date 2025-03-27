import java.io.*;
import java.util.*;

public class Main {
    
    static int StringSum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += s.charAt(i) - '0';
        return sum;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int n = 0, ans = 0;
        for (int i = 1; i <= S.length() / 2; i++) { 
            n = i * 2; 
            for (int j = 0; j < S.length() - n + 1; j++) { 
                String tmp = S.substring(j, j + n); 
                if (StringSum(tmp.substring(0, n / 2)) == StringSum(tmp.substring(n / 2))) { 
                    ans = n; 
                    break; 
                }
            }
        }
        System.out.println(ans);
    }

    
}