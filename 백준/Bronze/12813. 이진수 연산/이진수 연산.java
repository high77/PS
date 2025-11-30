import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String A = br.readLine(), B = br.readLine();
        StringBuilder and = new StringBuilder(100000);
        StringBuilder or = new StringBuilder(100000);
        StringBuilder xor = new StringBuilder(100000);
        StringBuilder notA = new StringBuilder(100000);
        StringBuilder notB = new StringBuilder(100000);

        for (int i = 0; i < 100000; i++) {
            char a = A.charAt(i), b = B.charAt(i);

            and.append((a == '1' && b == '1') ? '1' : '0');
            or.append((a == '1' || b == '1') ? '1' : '0');
            xor.append((a != b) ? '1' : '0');
            notA.append(a == '1' ? '0' : '1');
            notB.append(b == '1' ? '0' : '1');
        }

        System.out.println(and);
        System.out.println(or);
        System.out.println(xor);
        System.out.println(notA);
        System.out.println(notB);
    }
}