import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans =new StringBuilder();
        String s;
        HashSet<String> set = new HashSet<>();
        loop:
        while (!(s=br.readLine()).equals("*")) {
            int L = s.length();
            for (int i=1;i<L;i++) {
                set.clear();
                for (int j=0;j<L-i;j++) {
                    String tmp = s.charAt(j)+""+s.charAt(i+j);
                    if (set.contains(tmp)) {
                        ans.append(s).append(" is NOT surprising.\n");
                        continue loop;
                    }
                    set.add(tmp);
                }
            }
            ans.append(s).append(" is surprising.\n");
        }

        System.out.println(ans);
    }
}
