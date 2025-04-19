import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        double time;
        int index;

        public Pair(double time, int index) {
            this.time = time;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        

        ArrayList<Pair> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())
                    , y = Integer.parseInt(st.nextToken())
                    , v = Integer.parseInt(st.nextToken());

            double d = Math.sqrt(x*x + y*y);
            Pair p = new Pair(d/v, i+1);
            list.add(p);
        }

        Collections.sort(list, (a, b) -> {
            if(a.time < b.time)
                return -1;
            else if(a.time > b.time)
                return 1;
            else
                return a.index - b.index;
        });

        for(Pair p : list) {
            ans.append(p.index+"\n");
        }

        System.out.println(ans);
    }
}

