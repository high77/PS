import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String ans = "1".repeat(N)+"0".repeat(N-1);

        System.out.print(ans);
    }

}
