class Solution {
    public int[] solution(long n) {
        String N = n+"";
        int L = N.length();
        int[] ans = new int[L];
        for (int i=0;i<L;i++) ans[i] = N.charAt(L-i-1)-'0';
        return ans;
    }
}