import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken())
                , T = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) pq.add(Integer.parseInt(br.readLine()));
        int res = 0;
        boolean flag = false;
        if (pq.peek()<H) flag = true;
        else {
            for (int i = 0; i < T; i++) {
                if (pq.peek()==1) break;
                res++;
                pq.offer(pq.poll()/2);
                if (pq.peek()<H) {
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) res = pq.poll();
        if (!flag) ans.append("NO\n"+res);
        else ans.append("YES\n"+res);
        System.out.println(ans);
    }
}
