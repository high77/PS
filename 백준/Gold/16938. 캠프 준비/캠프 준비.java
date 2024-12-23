import java.io.*;
import java.util.*;

public class Main {
    static int N,L,R,X;
    static HashSet<String> set = new HashSet<>();
    static boolean[] visit;
    static int[] A;
    static void f(int min, int max, int k, int curV, int cnt){
        if (cnt>=2 && curV >= L && curV <= R && max-min>=X){
            set.add(Arrays.toString(visit));
        }
        if (k==N) return;
        f(min,max,k+1,curV,cnt);
        visit[k] = true;
        f(Math.min(min,A[k]),Math.max(max,A[k]),k+1,curV+A[k],cnt+1);
        visit[k] = false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        A = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        f(Integer.MAX_VALUE,Integer.MIN_VALUE,0,0,0);
        System.out.println(set.size());
    }
}
