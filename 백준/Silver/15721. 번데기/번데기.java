import java.io.*;
import java.util.*;

public class Main {
    static int A, T, BD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        BD = Integer.parseInt(br.readLine());

        System.out.print(play());
    }
    static int play() {
        int b = 0, d = 0;
        int n = 2;
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    b++;
                    if (b == T && BD == 0) return (b + d - 1) % A;
                }
                else {
                    d++;
                    if (d == T && BD == 1) return (b + d - 1) % A;
                }
            }

            for (int i = 0; i < n; i++) {
                b++;
                if (b == T && BD == 0) return (b + d - 1) % A;
            }

            for (int i = 0; i < n; i++) {
                d++;
                if (d == T && BD == 1) return (b + d - 1) % A;
            }
            n++;
        }
    }
}