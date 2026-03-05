import java.io.*;
import java.util.*;
    
class Solution {
    public String solution(String S) {
        String[] list = S.split(" ");
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        String ans = "";
        for (String s:list) {
            int n = Integer.parseInt(s);
            max = Math.max(max,n);
            min = Math.min(min,n);
        }
        ans = min+" "+max;         
        return ans;
    }
}