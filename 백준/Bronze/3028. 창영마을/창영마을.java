import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('1','0','0'));
        char[] S = br.readLine().toCharArray();
        for (char c : S) {
            if (c=='A') Collections.swap(list,0,1);
            else if (c=='B') Collections.swap(list,1,2);
            else Collections.swap(list,0,2);
        }
        System.out.println(list.indexOf('1')+1);
    }
}
