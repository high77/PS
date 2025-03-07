import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        int l= 0,r=0,cntL=0;
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            if (list[i]>0) r++;
            else l++;
        }
        Arrays.sort(list);
        int ans =0;
        if (l>0 && Math.abs(list[0])>list[list.length-1]) {
            ans -= list[0];
            cntL = Math.min(l,M);
        }else{
            ans+=list[N-1];
            r-=Math.min(r,M);
        }
        for (int i = cntL; i < l; i+=M) ans += Math.abs(list[i])*2;
        for (int i=r+l-1;i>=l;i-=M) ans += list[i]*2;
        System.out.println(ans);
    }
}
