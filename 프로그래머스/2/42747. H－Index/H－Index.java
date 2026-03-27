import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            int h = n - i; // 인용 횟수가 citations[i] 이상인 논문의 수
            
            // 인용 횟수가 논문 수(h)보다 크거나 같아지는 지점 확인
            if (citations[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }
}