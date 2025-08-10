import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine())
                , B = Integer.parseInt(br.readLine())
                , C = Integer.parseInt(br.readLine())
                , D = Integer.parseInt(br.readLine())
                , E = Integer.parseInt(br.readLine());
        int ans = 0;
        if (A<0) {
            ans += Math.abs(A)*C;
            A=0;
        }
        if (A==0) ans += D;
        ans += (B-A)*E;


        System.out.println(ans);
    }

}
