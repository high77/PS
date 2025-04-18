import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken());
        int[] train = new int[N];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken()), idx = Integer.parseInt(st.nextToken())-1;
            if (order == 1) train[idx] |= (1<<Integer.parseInt(st.nextToken())-1);
            else if (order == 2) train[idx] &= ~(1<<Integer.parseInt(st.nextToken())-1);
            else if (order == 3) train[idx] = (train[idx]<<1) & ~(1<<20);
            else train[idx] >>= 1;
            }
        for (int t:train) set.add(t);
        System.out.println(set.size());
    }
}