import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n==-1) break;
            else if (n==0) q.poll();
            else {
                if (q.size()<N) q.offer(n);
            }
        }
        if (q.isEmpty()) ans.append("empty");
        else {
            while (!q.isEmpty()) {
                ans.append(q.poll());
                if (!q.isEmpty()) ans.append(" ");
            }
        }
        System.out.println(ans);
    }
}