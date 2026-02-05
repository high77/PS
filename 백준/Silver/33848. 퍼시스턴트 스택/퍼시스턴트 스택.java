import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>(), stack12 = new Stack<>();
        StringTokenizer st ;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String q = st.nextToken();
            if (q.equals("1")) {
                stack.push(Integer.parseInt(st.nextToken()));
                stack12.push(1);
            }
            else if (q.equals("2")) stack12.push(stack.pop());
            else if (q.equals("3")) {
                int j = Integer.parseInt(st.nextToken());
                for (int k=0;k<j;k++){
                    int tmp = stack12.pop();
                    if (tmp==1) stack.pop();
                    else stack.push(tmp);
                }
            }
            else if (q.equals("4")) ans.append(stack.size()).append('\n');
            else {
                if (stack.isEmpty()) ans.append(-1);
                else ans.append(stack.peek());
                ans.append('\n');
            }
        }
        System.out.println(ans);
    }
}