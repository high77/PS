class Solution {
    public int solution(int N) {
        int ans = 0;
        int l = 0,r=1,sum=1;
        while (l<r && r<=N){
            if (sum>N) sum-=++l;
            else {
                if (sum==N) ans++;
                sum+=++r;
            }
        }
        
        return ans;
    }
}