import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = read(), t = n;

        int i = 1;
        while (t-- > 0) if (read() == i) i++;

        System.out.println(n-i+1);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}