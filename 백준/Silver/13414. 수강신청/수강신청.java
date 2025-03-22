import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken())
                , L = Integer.parseInt(st.nextToken()), cnt =0;
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String s = br.readLine();
            if (set.contains(s)) set.remove(s);
            set.add(s);
        }
        for (String s : set) {
            cnt++;
            ans.append(s+"\n");
            if (cnt == K) break;
        }

        System.out.println(ans);
    }
}
