import java.util.*;

class Solution {
    
    public int solution(int N, int[][] computers) {
        int ans = 0;
        boolean[] visit = new boolean[N];
        Queue<Integer> q ;
        for (int i=0;i<N;i++){
            if (visit[i]) continue;
            ans++;
            q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()){
                int now = q.poll();
                for (int next=0;next<N;next++){
                    if (visit[next] || computers[now][next]==0) continue;
                    q.add(next);
                    visit[next] = true;
                }
            }
        }
        return ans;
    }
}