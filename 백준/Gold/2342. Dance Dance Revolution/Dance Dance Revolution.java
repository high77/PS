import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int[][][] dp = new int[2][5][5];
        // 최대 누적 비용 = 100,000 * 4 = 400,000 이므로 INF는 그 이상으로 설정
        int INF = 400000, step = 0, target;
        
        // DP 배열 초기화
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) dp[0][i][j] = dp[1][i][j] = INF;
        dp[0][0][0] = 0;
        
        while ((target = sc.nextInt()) != 0) {
            int cur = step % 2, next = (step + 1) % 2;
            
            // 다음 단계의 DP 배열 초기화
            for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) dp[next][i][j] = INF;
            
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (dp[cur][i][j] == INF) continue;
                    
                    // 왼발을 target으로 이동 (오른발 위치 j와 겹치지 않아야 함)
                    if (target != j) 
                        dp[next][target][j] = Math.min(dp[next][target][j], dp[cur][i][j] + cost(i, target));
                    
                    // 오른발을 target으로 이동 (왼발 위치 i와 겹치지 않아야 함)
                    if (target != i) 
                        dp[next][i][target] = Math.min(dp[next][i][target], dp[cur][i][j] + cost(j, target));
                }
            }
            step++;
        }
        
        int ans = INF;
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) ans = Math.min(ans, dp[step % 2][i][j]);
        
        System.out.println(ans);
    }
    
    // 이동에 드는 힘을 계산하는 수학적 로직
    static int cost(int f, int t) {
        if (f == t) return 1;
        if (f == 0) return 2;
        if (Math.abs(f - t) == 2) return 4; // 반대 방향은 항상 절댓값 차이가 2
        return 3;                           // 그 외(인접 방향)는 모두 3
    }

    // 커스텀 스캐너
    static class FastScanner {
        InputStream is;
        byte[] buf = new byte[1024 * 64];
        int head = 0, tail = 0;
        
        public FastScanner(InputStream is) { this.is = is; }
        
        public int nextInt() throws Exception {
            int c = read();
            while (c <= 32) { if (c == -1) return -1; c = read(); }
            int res = 0;
            while (c > 32) { res = res * 10 + c - '0'; c = read(); }
            return res;
        }
        
        private int read() throws Exception {
            if (head >= tail) {
                head = 0;
                tail = is.read(buf, 0, buf.length);
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }
    }
}