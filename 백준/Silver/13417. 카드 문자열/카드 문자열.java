import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans  = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Deque<Character> dq;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            dq = new ArrayDeque<>();
            char tmp = input[0].charAt(0);
            dq.add(tmp);
            for (int i =1 ; i < N ; i++) {
                char nowC = input[i].charAt(0);
                if (dq.peek()> nowC) {
                    tmp = dq.peek();
                    dq.addFirst(nowC);
                }
                else if (dq.peek()==nowC) {
                    if (nowC<=tmp) dq.addFirst(nowC);
                    else dq.add(nowC);
                }
                else dq.add(nowC);
            }
            while (!dq.isEmpty()) ans.append(dq.removeFirst());
            ans.append('\n');
        }
        System.out.println(ans);
    }
}

