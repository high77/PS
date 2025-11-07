import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ans = "";
        while (true) {
            String S = br.readLine();
            String[] list = S.toLowerCase().split("[^a-z-]");
            for (String s : list) {
                if (s.equals("e-n-d")) {
                    System.out.println(ans.toLowerCase());
                    return;
                }
                ans = ans.length()< s.length() ? s : ans;
            }
        }
    }
}

