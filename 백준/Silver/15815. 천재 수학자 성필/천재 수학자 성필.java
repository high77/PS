import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (char c:S) {
            if (Character.isDigit(c)) stack.push(c-'0');
            else {
                int a = stack.pop(), b = stack.pop();
                if (c=='-') stack.add(b-a);
                else if (c=='+') stack.add(a+b);
                else if (c=='*') stack.add(a*b);
                else if (c=='/') stack.add(b/a);    
            }
        }

        System.out.println(stack.pop());
    }
}
