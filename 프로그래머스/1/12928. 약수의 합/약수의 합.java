class Solution {
    public int solution(int N) {
        int ans = 0;
        for (int i=1;i*i<=N;i++){
            if (N%i==0) {
                int a = N/i;
                int b = N/a;
                ans+=a;
                if (a!=b) ans+=b;
            } 
        }
        return ans;
    }
}