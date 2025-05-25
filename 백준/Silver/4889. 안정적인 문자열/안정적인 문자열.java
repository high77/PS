import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int tc = 1;
        Stack<Character> stack;
        while (true) {
            String s = br.readLine();
            if (s.contains("-")) break;
            stack = new Stack<>();
            int res = 0;
            for (char c : s.toCharArray()) {
                if (c == '{') stack.push(c);
                else {
                    if (stack.isEmpty()) {
                        res++;
                        stack.push('{');
                    }else stack.pop();
                }
            }
            res +=stack.size()/2;
            ans.append(tc+". "+res+"\n");
            tc++;
        }
        System.out.println(ans);
    }


}
