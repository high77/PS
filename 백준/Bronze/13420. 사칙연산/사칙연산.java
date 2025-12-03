import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            String op = st.nextToken();
            long b = Long.parseLong(st.nextToken());
            st.nextToken(); 
            long c = Long.parseLong(st.nextToken());

            long res;
            switch (op) {
                case "+":
                    res = a + b;
                    break;
                case "-":
                    res = a - b;
                    break;
                case "*":
                    res = a * b;
                    break;
                default: // "/"
                    res = a / b;
                    break;
            }

            ans.append(res == c ? "correct" : "wrong answer").append('\n');
        }

        System.out.print(ans);
    }
}
