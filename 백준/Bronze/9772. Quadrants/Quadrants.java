import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) continue;

            double x = Double.parseDouble(st.nextToken()), y = Double.parseDouble(st.nextToken());

            if (x == 0 || y == 0) {
                System.out.println("AXIS");
                if (x == 0 && y == 0) break;
            } else if (x > 0 && y > 0) System.out.println("Q1");
            else if (x < 0 && y > 0) System.out.println("Q2");
            else if (x < 0 && y < 0) System.out.println("Q3");
            else System.out.println("Q4");
        }
    }
}