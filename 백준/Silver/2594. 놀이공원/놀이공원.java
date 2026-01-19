import java.io.*;
import java.util.*;

public class Main {
    static class Time implements Comparable<Time> {
        int s,e;
        public Time(String s, String e) {
            this.s = (Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(2))) - 10;
            this.e = Math.min((Integer.parseInt(e.substring(0, 2)) * 60 + Integer.parseInt(e.substring(2))) + 10,1320);
        }
        @Override
        public int compareTo(Time o) {
            return s-o.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Time[] times = new Time[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = new Time(st.nextToken(), st.nextToken());
        }
        Arrays.sort(times);
        int now = 600,ans =0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(times[i].s - now, ans);
            now = Math.max(now, times[i].e);
        }

        ans = Math.max(ans, 1320-now);

        System.out.println(ans);
    }
}