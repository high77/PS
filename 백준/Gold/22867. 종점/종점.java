import java.io.*;
import java.util.*;

public class Main {
    static class Time{
        int in;
        int out;
        Time(int in, int out){
            this.in = in;
            this.out = out;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans =0;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> times = new ArrayList<Time>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            input[0] = input[0].replaceAll(":","").replace(".","");
            input[1] = input[1].replaceAll(":","").replace(".","");
            Time t = new Time(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
            times.add(t);
        }
        times.sort((t1, t2) -> t1.in-t2.in);
        int now =0;
        PriorityQueue<Time> pq = new PriorityQueue<>((t1, t2) -> t1.out-t2.out);
        for (Time t : times) {
            if (pq.isEmpty()) {
                pq.add(t);
                now++;
            }
            else{
                while (!pq.isEmpty() && pq.peek().out <= t.in){
                    pq.poll();
                    now--;
                }
                pq.add(t);
                now++;
            }
            ans = Math.max(ans, now);
        }
        System.out.print(ans);
    }
}
