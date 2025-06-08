import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < R; j++) {
                if (i*2+(j-2)*2==R && (i-2)*(j-2)==B) {
                    ans.append(j+" "+i);
                    System.out.println(ans);
                    return;
                }
            }
        }

    }
}