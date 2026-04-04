import java.util.*;

class Solution
{
    public int solution(String S)
    {
        int ans = 0;
        Stack<Character> stack = new Stack();
        for (char c:S.toCharArray()) {
            if (stack.isEmpty() || stack.peek()!=c) stack.add(c);
            else stack.pop();
        }
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}