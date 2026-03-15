class Solution {
    public int[] solution(String S) {
        int[] ans = {0,0};
        while (true){
            int C = 0;
            for (int i=0;i<S.length();i++) {
                char c = S.charAt(i);
                if (c=='0') ans[1]++;
                else C++;
            }
            ans[0]++;
            if (C==1) break;
            S = Integer.toString(C,2);
        }   
        return ans;
    }
}