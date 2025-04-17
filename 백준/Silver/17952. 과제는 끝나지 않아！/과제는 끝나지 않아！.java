import java.io.*;
import java.util.*;
public class Main{
    static class Work {
        int score, time;
        public Work(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine()),ans = 0;
        Stack<Work> stack = new Stack<>();
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")){
                int score = Integer.parseInt(st.nextToken())
                        , time = Integer.parseInt(st.nextToken());
                if (time == 1) ans += score;
                else stack.add(new Work(score, time-1));
            }else{
                if (stack.isEmpty()) continue;
                Work w = stack.pop();
                if (w.time == 1) ans += w.score;
                else stack.add(new Work(w.score, w.time-1));
            }
        }

        System.out.println(ans);
    }
}