import java.util.*;

class Solution {
    public long solution(long N) {
        char[] chars = String.valueOf(N).toCharArray();
        Arrays.sort(chars);
        String n = new StringBuilder(new String(chars)).reverse().toString();
        return Long.parseLong(n);
    }
}