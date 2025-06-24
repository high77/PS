import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine()), sum =0;
        int[] list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            if(i == 0) list[0] = tmp;
            else list[i] = (tmp * (i + 1)) - sum;

            sum += list[i];
        }

        for(int n : list) ans.append(n).append(" ");
        System.out.println(ans);
    }

}