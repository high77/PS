import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine()), fibo[] = new int[46];
        fibo[1] = 1;

        for (int i = 2; i < 46; i++) fibo[i] = fibo[i - 1] + fibo[i - 2];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<T;i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j=45;j>0;j--){
                if (n==0) break;
                if (fibo[j]<=n){
                    n-=fibo[j];
                    stack.push(j);
                }
            }
            while (!stack.isEmpty())ans.append(fibo[stack.pop()]).append(" ");
            ans.append('\n');
        }

        System.out.println(ans);
    }
}
