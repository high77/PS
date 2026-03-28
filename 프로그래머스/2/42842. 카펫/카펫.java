class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] ans = new int[2];
        for (int i=3;i*i<=total;i++){
            if (total%i!=0)continue;
            int j = total/i;
            int b = (i+j)*2-4;
            if (b == brown) {
                ans[0] = j;
                ans[1] = i;
                return ans;
            }
        }
        return ans;
    }
}