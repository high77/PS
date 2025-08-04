import java.io.*;
import java.util.*;

public class Main {
    static class Meeting implements Comparable<Meeting> {
        int start, end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Meeting o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(s, e);
        }

        Arrays.sort(meetings);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(meetings[0].end);

        for (int i = 1; i < N; i++) {
            if (meetings[i].start >= pq.peek()) pq.poll();
            pq.offer(meetings[i].end);
        }

        System.out.println(pq.size());
    }
}
