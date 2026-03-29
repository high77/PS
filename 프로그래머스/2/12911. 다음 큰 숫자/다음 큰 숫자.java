class Solution {
    public int solution(int N) {
        int cnt = Integer.bitCount(N);
        while (true) {
            N++;
            if (Integer.bitCount(N)==cnt) return N;
        }
    }
}