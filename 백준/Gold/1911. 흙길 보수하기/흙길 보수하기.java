import java.io.*;
import java.util.*;

public class Main {
    static class Pool implements Comparable<Pool> {
        int s,e;
        public Pool(int s, int e){
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Pool p){
            return Integer.compare(this.s, p.s);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                ,L = Integer.parseInt(st.nextToken());
        Pool[] pools = new Pool[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pools[i] = new Pool(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }
        Arrays.sort(pools);
        int tmp = 0,ans=0, last = 0;
        for (Pool p : pools) {
            if (last>=p.e) continue;
            last = Math.max(last, p.s);
            tmp = (p.e-last+L-1)/L;
            ans += tmp;
            last += tmp*L;
        }
        System.out.println(ans);
    }

}