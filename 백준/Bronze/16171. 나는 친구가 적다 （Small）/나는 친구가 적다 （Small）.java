import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        char[] S = br.readLine().toCharArray();
        for (char c:S){
            if (!Character.isDigit(c)) ans.append(c);
        }
        if (ans.toString().contains(br.readLine())) System.out.println(1);
        else System.out.println(0);

//        System.out.println(ans);


    }
}