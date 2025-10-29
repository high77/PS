import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0, num = 100000;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int temp = Integer.parseInt(st.nextToken());
                queue.add(temp);
                if (queue.size() >= cnt) {
                    if (queue.size() == cnt) {
                        if (num > temp)
                            num = temp;
                    } else {
                        cnt = queue.size();
                        num = temp;
                    }
                }
            } else {
                queue.poll();
            }
        }
        System.out.println(cnt +" "+num);

    }
}