import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        if (A>B){
            if(B>=N) ans.append("Subway");
            else ans.append("Bus");
        }
        else if (A<B) ans.append("Bus");
        else {
            if(B>=N) ans.append("Anything");
            else ans.append("Bus");
        }
        System.out.println(ans);
    }
}