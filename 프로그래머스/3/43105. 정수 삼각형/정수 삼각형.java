class Solution {
    public int solution(int[][] arr) {
        int l = arr.length;
        int[][] dp = new int[l][l];
        dp[0][0] = arr[0][0];
        int ans = 0;
        for (int i=1;i<l;i++){
            for (int j=0;j<=i;j++){
                if (j==0) dp[i][j] = dp[i-1][j]+arr[i][j];
                else if (j==i) dp[i][j] = dp[i-1][j-1]+arr[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];                
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}