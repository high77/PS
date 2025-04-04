import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken().replace(":",""))
                , E = Integer.parseInt(st.nextToken().replace(":",""))
                , Q = Integer.parseInt(st.nextToken().replace(":",""));

        String input = "";
        int cnt = 0;
        while((input = br.readLine()) != null && !input.isEmpty()) {
            st = new StringTokenizer(input);

            int T = Integer.parseInt(st.nextToken().replace(":", ""));
            String name = st.nextToken();

            if(T<=S) set.add(name);

            if(E<=T && T<=Q && set.contains(name)) {
                cnt++;
                set.remove(name);
            }
        }
        System.out.println(cnt);
    }
}