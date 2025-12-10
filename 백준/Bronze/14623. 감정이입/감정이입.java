import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String B1 = br.readLine(), B2 = br.readLine();

        long B1n = Long.parseLong(B1, 2), B2n = Long.parseLong(B2, 2);
        String ans = Long.toBinaryString(B1n * B2n);

        System.out.println(ans);
    }
}
