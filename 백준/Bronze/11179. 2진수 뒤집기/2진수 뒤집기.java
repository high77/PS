import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String binary = Integer.toBinaryString(Integer.parseInt(br.readLine()));

        String reversed = new StringBuilder(binary).reverse().toString();

        System.out.println(Long.parseLong(reversed, 2));
    }
}