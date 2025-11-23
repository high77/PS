
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long junwon = Long.parseLong(st.nextToken());
        long[] list = new long[N - 1];
        for (int i = 0; i < N - 1; i++) list[i] = Long.parseLong(st.nextToken());

        Arrays.sort(list);

        for (int i = 0; i < N - 1; i++) {
            if (junwon > list[i]) junwon += list[i];
            else {
                ans.append("No");
                break;
            }
        }

        if (ans.length() == 0) ans.append("Yes");

        System.out.println(ans);

    }
}
