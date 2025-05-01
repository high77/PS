import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            ans *= i;
            ans %=10000000;
            while (ans %10== 0) ans /=10;
        }
        System.out.println(ans%10);
    }

}