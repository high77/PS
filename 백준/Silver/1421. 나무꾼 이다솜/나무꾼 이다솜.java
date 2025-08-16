import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        long C=Long.parseLong(st.nextToken())
                ,W=Long.parseLong(st.nextToken()), ans =Integer.MIN_VALUE, res =0,cost=0;
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) trees[i] = Integer.parseInt(br.readLine());
        Arrays.sort(trees);
        for (int i = 1; i <= trees[N-1]; i++) {
            res = 0;
            for (int j = 0; j < N; j++) {
                cost = 0;
                if(trees[j] >= i) {
                    cost = trees[j]/i;
                    if(trees[j] % i == 0) cost--;
                    res += Math.max(W * i * (trees[j] /i) - cost * C,0);
                }
            }
            ans = Math.max(ans, res);
        }
        System.out.println(ans);
    }
}