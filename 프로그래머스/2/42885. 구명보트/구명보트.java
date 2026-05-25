import java.util.*;

class Solution {
    public int solution(int[] list, int limit) {
        int ans = 0;
        int L = list.length;
        int s=0,e=L-1;
        Arrays.sort(list);
        while (s<e){
            if (list[s]+list[e]<=limit) s++;
            e--;
            ans++;
        }
        if (s==e) ans++;
        return ans;
    }
}