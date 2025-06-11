import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        double sum = 0, ssum = 0;
        for(int i = 0; i < N; i++) {
            double tmp = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            ssum += a;
            String score = st.nextToken();
            if (score.equals("F")) continue;
            if (score.charAt(0) == 'A') tmp = 4;
            else if (score.charAt(0) == 'B') tmp = 3;
            else if (score.charAt(0) == 'C') tmp = 2;
            else if (score.charAt(0) == 'D') tmp = 1;
            if (score.charAt(1) == '+') tmp += 0.3;
            else if (score.charAt(1) == '-') tmp -= 0.3;

            sum += a * tmp;
        }

        System.out.println(String.format("%.2f", sum/ssum));
    }
}


