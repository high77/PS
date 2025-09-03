import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        System.out.println(f(k - 1));
    }

    private static int f(long k) {
        if (k == 0) return 0;
        if (k == 1) return 1;
        if (k % 2 == 0) return f(k / 2);
        return 1 - f(k / 2);
    }
}