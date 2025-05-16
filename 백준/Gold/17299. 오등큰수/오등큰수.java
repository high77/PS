import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            map.put(list[i],map.getOrDefault(list[i],0)+1);
        }

        int[] res = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i=N-1; i>=0; i--) {
            int n = map.get(list[i]);
            while (!stack.isEmpty() && map.get(stack.peek()) <= n) stack.pop();
            if (stack.isEmpty()) res[i] = -1;
            else res[i] = stack.peek();
            stack.push(list[i]);
        }
        for (int i = 0; i < N; i++) ans.append(res[i]+" ");
        System.out.println(ans);
    }
}
