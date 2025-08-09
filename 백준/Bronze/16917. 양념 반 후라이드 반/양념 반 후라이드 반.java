import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken())
                , B = Integer.parseInt(st.nextToken())
                , C = Integer.parseInt(st.nextToken())
                , X = Integer.parseInt(st.nextToken())
                , Y = Integer.parseInt(st.nextToken());
        int ans = 0;
        if(A+B > C*2) {
            ans += C*2*Math.min(X, Y);
            if(X > Y) { 
                if(C*2 < A) ans += C*2*(X-Y);
                else ans += (X-Y) * A;
            }
            else {
                if(C*2 < B) ans += C*2*(Y-X);
                else ans += (Y-X) * B;
            }
        }
        else ans += A*X + B*Y;

        System.out.println(ans);
    }

}
