import java.util.*;

class Solution {
    static class Node{
        int x,y,cnt;
        Node(int x,int y,int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;            
        }
    }
    public int solution(String[] maps) {
        int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
        int ans = 0;
        boolean flag = false;
        int N = maps.length, M = maps[0].length();
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (maps[i].charAt(j)=='S'){
                    Queue<Node> q = new LinkedList<Node>();
                    q.add(new Node(i,j,0));
                    boolean[][] visit = new boolean[N][M];
                    visit[i][j] = true;
                    int x=0,y=0;
                    while (!q.isEmpty()){
                        Node cur = q.poll();
                        if (maps[cur.x].charAt(cur.y)=='L'){
                            flag = true;
                            x = cur.x;
                            y = cur.y;
                            ans+=cur.cnt;
                            break;
                        }
                        for (int d=0;d<4;d++){
                            int nx = cur.x+dx[d], ny = cur.y+dy[d];
                            if (nx<0 || ny<0 || nx>=N || ny>=M || maps[nx].charAt(ny) == 'X' || visit[nx][ny]) continue;
                            visit[nx][ny] = true;
                            q.add(new Node(nx,ny,cur.cnt+1));                            
                        }
                    }
                    if (!flag) {
                        ans = -1;
                        break;
                    }
                    flag = false;
                    q = new LinkedList<Node>();
                    q.add(new Node(x,y,0));
                    visit = new boolean[N][M];
                    visit[x][y] = true;
                    while (!q.isEmpty()){
                        Node cur = q.poll();
                        if (maps[cur.x].charAt(cur.y)=='E') {
                            flag = true;
                            ans += cur.cnt;
                            break;
                        }
                        for (int d=0;d<4;d++){
                            int nx = cur.x+dx[d], ny = cur.y+dy[d];
                            if (nx<0 || ny<0 || nx>=N || ny>=M || maps[nx].charAt(ny) == 'X' || visit[nx][ny]) continue;
                            visit[nx][ny] = true;
                            q.add(new Node(nx,ny,cur.cnt+1));                            
                        }
                    }
                    if (!flag) ans = -1;
                    break; 
                }
            }
            if (ans!=0) break;
        }
        return ans;
    }
}