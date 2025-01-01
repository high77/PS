import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] length = new int[N];
        for (int i = 0; i < N; i++) length[i] = Integer.parseInt(br.readLine());
        Arrays.sort(length);
        for (int i = N-1; i >= 2 ; i--) {
            int tmp = length[i - 2]+length[i - 1];
            if (tmp>length[i]) {
                ans.append(tmp+length[i]);
                break;
            }
            if (i==2) ans.append(-1);
        }
        System.out.println(ans);
    }
}