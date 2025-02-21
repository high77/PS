import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken()), cnt=0;
        boolean flag = true;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) dq.addLast(i);
        while (!dq.isEmpty()) {
            int k = K%dq.size();
            if (k==0){
                int n;
                if(!flag) n =dq.removeFirst();
                else n = dq.removeLast();
                ans.append(n+"\n");
            }else {
                for (int i=0;i<k;i++){
                    if(flag) {
                        int n = dq.removeFirst();
                        if (i==k-1) {
                            ans.append(n+"\n");
                            continue;
                        }
                        dq.addLast(n);
                    }else{
                        int n = dq.removeLast();
                        if (i==k-1){
                            ans.append(n+"\n");
                            continue;
                        }
                        dq.addFirst(n);
                    }
                }
            }
            cnt++;
            if (cnt==M) {
                flag = !flag;
                cnt=0;
            }
        }
        System.out.println(ans);
    }
}
