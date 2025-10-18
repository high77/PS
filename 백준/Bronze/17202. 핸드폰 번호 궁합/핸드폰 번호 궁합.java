import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine(), s2=  br.readLine(), s = "";
        for (int i = 0; i < s1.length(); i++) {
            s += s1.charAt(i);
            s += s2.charAt(i);
        }
        while (s.length() > 2) {
            String S = "";
            for (int i = 0; i < s.length()-1; i++) {
                int n = Character.getNumericValue(s.charAt(i)) + Character.getNumericValue(s.charAt(i+1));
                S += Integer.toString(n%10);
            }
            s = S;
        }
        System.out.print(s);
    }
}