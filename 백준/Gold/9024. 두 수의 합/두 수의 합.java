import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
            int[] list = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(list);
            int cnt =0,res=Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int s=i+1,e = N;
                while (s<e) {
                    int mid = (s+e)/2;
                    int V =K-(list[i]+list[mid]);
                    if (Math.abs(V) < res){
                        res = Math.abs(V);
                        cnt = 1;
                    }else if (Math.abs(V) == res) cnt++;
                    if (V>0) s=mid+1;
                    else if (V<0) e=mid;
                    else break;
                }
            }
            ans.append(cnt+"\n");
        }

        System.out.print(ans);
    }
}
