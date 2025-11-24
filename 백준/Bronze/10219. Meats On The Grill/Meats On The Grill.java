
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());

            for (int h = 0; h < H; h++) {
                String line = br.readLine();
                for (int w = W - 1; w >= 0; w--) ans.append(line.charAt(w));
                ans.append("\n");
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
