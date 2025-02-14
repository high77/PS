import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int bit = ~N+1;
        int bit2 = N^bit;
        int res = 0;
        for (char c:Integer.toBinaryString(bit2).toCharArray()) res+=Integer.parseInt(c+"");

        System.out.println(res);
    }
}
