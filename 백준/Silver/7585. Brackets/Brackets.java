import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        while (true) {
            char[] S = br.readLine().toCharArray();
            if (S.length==1 && S[0]=='#') break;
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (char c : S) {
                if (c == '(' || c=='{' || c=='[') stack.push(c);
                else if (c==')' || c=='}' || c==']') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if (c==')') {
                        if (stack.peek()=='(') stack.pop();
                        else {
                            flag = false;
                            break;
                        }
                    }
                    else if (c=='}') {
                        if (stack.peek()=='{') stack.pop();
                        else {
                            flag = false;
                            break;
                        }
                    }
                    else {
                        if (stack.peek()=='[') stack.pop();
                        else {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (!stack.isEmpty()) flag = false;
            if (flag) ans.append("Legal");
            else ans.append("Illegal");
            ans.append("\n");
        }
        System.out.print(ans);
    }
}
