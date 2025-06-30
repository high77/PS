import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String S = br.readLine();
        int a =0, b =0;
        for (int i = 3; i <= S.length(); i++) {
            String tmp = S.substring(i - 3, i);
            if (tmp.equals("JOI")) a++;
            if (tmp.equals("IOI")) b++;
        }
        System.out.println(a+"\n"+b);
    }


}