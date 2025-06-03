import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken()),res =0,list[] = new int[20];
            for (int j = 0; j < 20; j++) {
                list[j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < j; k++) {
                    if (list[k] > list[j]) res++;
                }
            }
            ans.append(T).append(" ").append(res).append("\n");
        }
        System.out.println(ans);
    }
}