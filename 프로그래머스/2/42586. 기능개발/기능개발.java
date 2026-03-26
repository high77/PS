import java.util.*;

class Solution {
    public ArrayList solution(int[] A, int[] B) {
        ArrayList ans = new ArrayList();
        int L = A.length;
        int[] days = new int[L];
        for (int i=0;i<L;i++) days[i] = (100-A[i])/B[i] + ((100-A[i])%B[i] !=0? 1:0);   
        int tmp = days[0], cnt = 1;
        for (int i=1;i<L;i++) {
            if (days[i]<=tmp) cnt++;
            else {
                ans.add(cnt);
                tmp = days[i];
                cnt = 1;
            }
        }
        ans.add(cnt);
        return ans;
    }
}