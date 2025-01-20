import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int[] dx = {-1,-1,-1,0,0,1,1,1},dy = {-1,0,1,-1,1,-1,0,1};
    static int[][] A,land,tmp2;
    static PriorityQueue<Tree> tree;
    static class Tree implements Comparable<Tree> {
        int x;
        int y;
        int age;
        Tree(int x,int y,int age){
            this.x=x;
            this.y=y;
            this.age=age;
        }
        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age,o.age);
        }

    }

    static void spring(){
        PriorityQueue<Tree> tmp = new PriorityQueue<>();
        tmp2 = new int[N][N];
        while (!tree.isEmpty()){
            Tree t = tree.poll();
            if (land[t.x][t.y]<t.age) {
                tmp2[t.x][t.y]+=t.age/2;
                continue;
            }
            land[t.x][t.y]-=t.age;
            tmp.offer(new Tree(t.x,t.y,t.age+1));
        }
        tree = tmp;
    }

    static void summer(){
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++) land[i][j]+=tmp2[i][j];
        }
    }

    static void fall(){
        PriorityQueue<Tree> tmp = new PriorityQueue<>();
        while (!tree.isEmpty()){
            Tree t = tree.poll();
            tmp.offer(t);
            if (t.age%5!=0) continue;
            for (int d=0;d<8;d++){
                int x=t.x+dx[d], y=t.y+dy[d];
                if (x<0 || y<0 || x>=N || y>=N) continue;
                tmp.offer(new Tree(x,y,1));
            }
        }
        tree = tmp;
    }

    static void winter(){
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++) land[i][j] += A[i][j];
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        land = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                land[i][j] = 5;
            }
        }
        tree = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            tree.offer(new Tree(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < K; i++) {
            spring();
            summer();
            fall();
            winter();
        }
        ans.append(tree.size());
        System.out.println(ans);
    }
}
