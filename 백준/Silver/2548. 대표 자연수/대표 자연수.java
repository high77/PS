import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine()), ans =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for(int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int res = 0;
            if (i>1 && list[i] == list[i-1]) continue;
            for (int j = 0; j < N; j++) res += Math.abs(list[i]-list[j]);
            if (res < min) {
                min = res;
                ans = list[i];
            }
        }
        System.out.println(ans);
    }
}