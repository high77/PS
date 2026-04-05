class Solution {
    public int[] solution(int N, long S, long E) {
        int L = (int)(E-S+1);
        int[] ans = new int[L];
        for (int i = 0; i < L; i++) {
            long currentIdx = S + i;
            long row = currentIdx / N;
            long col = currentIdx % N;
            
            ans[i] = (int) Math.max(row, col) + 1;
        }
        return ans;
    }
}