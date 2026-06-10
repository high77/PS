class Solution {
    public double solution(int[] arr) {
        int L = arr.length;
        int res = 0;
        for (int i:arr)res += i;
        
        double ans = (double) res/L;
        return ans;
    }
}