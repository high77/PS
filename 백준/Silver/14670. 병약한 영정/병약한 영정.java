import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans =new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        StringTokenizer st ;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        int R = Integer.parseInt(br.readLine());
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int d = Integer.parseInt(st.nextToken());
                if (map.containsKey(d)) ans.append(map.get(d));
                else {
                    ans.setLength(0);
                    ans.append("YOU DIED");
                    break;
                }
                if (j<cnt-1) ans.append(" ");
            }
            System.out.println(ans);
            ans.setLength(0);
        }
    }
}
