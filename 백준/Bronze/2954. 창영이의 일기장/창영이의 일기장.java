import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String s = br.readLine();

        ans.append(s.replaceAll("(?:([a|e|i|o|u]{1})(p{1})([a|e|i|o|u{1}]))", "$1"));
        System.out.println(ans);
    }
}