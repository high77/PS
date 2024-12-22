import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine())
                ,ans = 0, max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int B = Integer.parseInt(st.nextToken())
                    , tmp = 0;
            while (B>0) {
                if (B%2==0) {
                    B/=2;
                    tmp++;
                }else{
                    B--;
                    ans++;
                }
            }
            max = Math.max(max, tmp);
        }
        System.out.println(ans+max);
    }
}
