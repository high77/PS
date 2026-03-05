import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String S) {
        boolean answer = true;

        int left = 0;
        for (int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if (c == '(') left++;
            else left--;
            if (left<0) break;
        }
        if (left!=0) answer = false;

        return answer;
    }
}