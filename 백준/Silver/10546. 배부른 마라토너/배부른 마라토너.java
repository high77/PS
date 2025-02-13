import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N*2-1; i++) {
            String s = br.readLine();
            if (set.contains(s)) set.remove(s);
            else set.add(s);
        }
        System.out.print(set.toArray()[0]);
    }
}
