import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , P = Integer.parseInt(st.nextToken()), ans=0;
        Stack<Integer>[] stack = new Stack[7];
        for (int i = 0; i < 7; i++) stack[i] = new Stack<>();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())
                    , b = Integer.parseInt(st.nextToken());
            while (!stack[a].empty() && stack[a].peek()>b){
                if (stack[a].peek() > b) {
                    stack[a].pop();
                    ans++;
                }
            }
            if (!stack[a].empty() && stack[a].peek() == b) continue;
            stack[a].push(b);
            ans++;
        }
        System.out.println(ans);
    }
}