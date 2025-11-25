
import java.io.*;
import java.util.*;

public class Main {
    static boolean isPal(String s){
        boolean flag = true;

        for (int i = 0; i < s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length()-i-1)){
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            String S = br.readLine().toUpperCase();
            if (isPal(S)) ans.append("Yes");
            else ans.append("No");
            ans.append("\n");
        }

        System.out.println(ans);
    }
}
