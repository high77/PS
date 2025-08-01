import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            map.put(a, map.getOrDefault(a,0)+b);
        }
        String ans = "NO";
        for (String key : map.keySet()) {
            if(map.get(key)==5) ans = "YES";
        }
        System.out.println(ans);
    }
}

