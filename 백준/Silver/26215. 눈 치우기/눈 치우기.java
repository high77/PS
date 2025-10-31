import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) pq.add(Integer.parseInt(st.nextToken()));
        int ans =0 ;
        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll();
            ans+=b;
            if (a-b!=0) pq.add(a-b);
        }
        ans += pq.isEmpty()?0:pq.poll();

        System.out.println(ans>1440?-1:ans);

    }
}