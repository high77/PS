public class Solution {
    public int solution(int N) {
        int ans = 0;
        while (N!=0){
            ans+= N%2;
            N/=2;
        }
        return ans;
    }
}