import java.util.*;

public class Solution {
    public int solution(int N) {
        int ans = 0;

        while (N!=0){
            ans+=N%10;
            N/=10;
        }
        return ans;
    }
}