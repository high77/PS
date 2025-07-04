import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int a = 0;

        for (int i = 2; i <= 100; i++) {
            a = (int) Math.pow(i, 3);

            for (int b = 2; b <= i; b++) {
                for (int c = b; c <= i; c++) {
                    for (int d = c; d <= i; d++) {
                        int sum = (int) Math.pow(b, 3) + (int) Math.pow(c, 3) + (int) Math.pow(d, 3);

                        if (a == sum) ans.append("Cube = ").append(i).append(", Triple = (").append(b).append(",").append(c).append(",").append(d).append(")").append("\n");
                    }
                }
            }
        }

        System.out.println(ans);
    }
}