import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), i=0, ans=0,bonus=0;
        char[] S = br.readLine().toCharArray();
        for (char c : S) {
            i++;
            if (c=='O') ans+=i+bonus++;
            else bonus=0;
        }
        System.out.println(ans);
    }
}
