import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        String s ,regex=".*BUG.*";
        while ((s=br.readLine())!= null){
            while (s.matches(regex)) s = s.replaceAll("BUG","");
            System.out.println(s);
        }
//        System.out.println(ans);

    }
}
