import java.util.StringTokenizer;
import java.io.*;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        long N = Long.parseLong(br.readLine()), n=1,ans=0;
        while (N>0) {
            if ((N&1)==1) ans+=n;
            n*=3;
            N=N>>1;
        }
        System.out.println(ans);
    }


}