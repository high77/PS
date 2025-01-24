import java.util.*;
import java.io.*;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        BitSet set = new BitSet();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if (set.get(n)) continue;
            ans.append(n+" ");
            set.set(n);
        }
        System.out.println(ans);
    }
}