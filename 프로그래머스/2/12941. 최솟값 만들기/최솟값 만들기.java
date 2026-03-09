import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int ans = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int l = A.length;
        for (int i=0;i<l;i++) ans += A[i]*B[l-i-1];

        return ans;
    }
}