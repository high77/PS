import java.io.*;
import java.util.*;
public class Main{
    static int N,M,arr[][],cheese, dx[] = {0,0,1,-1}, dy[] = {1,-1,0,0};
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        q.add(new int[]{0,0});
        visit[0][0] = true;
        while(!q.isEmpty()){
            int now[] = q.poll();

            for(int d=0;d<4;d++){
                int nx = now[0]+dx[d], ny = now[1]+dy[d];
                if(0>nx || nx>=N || 0>ny || ny>=M || visit[nx][ny]) continue;
                visit[nx][ny]=true;
                if(arr[nx][ny]==1){
                    arr[nx][ny] = 0;
                    cheese--;
                    }
                else if(arr[nx][ny]==0) q.add(new int[]{nx,ny});
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        cheese =0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    cheese++;
                }
            }
        }

        int time =0, res = 0;
        while(cheese>0){
            res = cheese;
            bfs();
            time++;
        }

        ans.append(time+"\n"+res);
        System.out.println(ans);

    }


}