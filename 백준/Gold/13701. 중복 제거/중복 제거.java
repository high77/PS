import java.util.StringTokenizer;
import java.io.*;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int[] list = new int[1<<20];
        for (String s : input) {
            int n = Integer.parseInt(s);
            int i = n/32, bit = n%32;
            if ((list[i]&(1<<n%32))==0) ans.append(s+" ");
            list[i]|=(1<<bit);
        }
        System.out.println(ans);

    }
}