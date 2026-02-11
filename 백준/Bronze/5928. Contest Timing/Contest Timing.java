import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int startTotal = (11 * 24 * 60) + (11 * 60) + 11;

        int endTotal = (D * 24 * 60) + (H * 60) + M;

        int diff = endTotal - startTotal;

        System.out.println(diff < 0 ? -1 : diff);
    }
}