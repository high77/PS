import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static class Beer implements Comparable<Beer> {
        int prefer, alcohol;

        public Beer(int prefer, int alcohol) {
            this.prefer = prefer;
            this.alcohol = alcohol;
        }

        @Override
        public int compareTo(Beer o) {
            if (this.alcohol == o.alcohol) return o.prefer - this.prefer;

            return this.alcohol - o.alcohol;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),M = Integer.parseInt(st.nextToken()),K = Integer.parseInt(st.nextToken());

        List<Beer> beers = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken());
            beers.add(new Beer(p, a));
        }

        Collections.sort(beers);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total = 0, ans = -1;

        for (Beer beer : beers) {
            pq.add(beer.prefer);
            total += beer.prefer;

            if (pq.size() > N) total -= pq.poll();
            if (pq.size() == N && total >= M) {
                ans = beer.alcohol;
                break;
            }
        }

        System.out.print(ans);
    }
}
