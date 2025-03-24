import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] list =  new int[K];
        for (int i = 0; i < K; i++) list[i] = Integer.parseInt(st.nextToken());

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for (int i = 0; i < K; i++) {
            if (set.contains(list[i])) continue;
            if (set.size() < N && set.add(list[i])) continue;

            int farthest = -1, toRemove = -1;
            for (int s:set) {
                int next =Integer.MAX_VALUE;
                for (int j=i+1;j<K;j++) {
                    if (list[j] == s) {
                        next = j;
                        break;
                    }
                }

                if (next>farthest) {
                    farthest = next;
                    toRemove = s;
                }
            }

            set.remove(toRemove);
            set.add(list[i]);
            ans++;
        }

        System.out.println(ans);
    }
}
