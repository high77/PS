import java.util.*;

class Solution {
    public String solution(String[] A, String[] B) {
        HashMap<String,Integer> map = new HashMap();
        for (String a:A) map.put(a,map.getOrDefault(a,0)+1);
        for (String b:B) map.put(b,map.get(b)-1);
        for (String a:A) {
            if (map.get(a)!=0) {
                return a;
            }
        }
        return "0";
    }
}