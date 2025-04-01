import java.io.*;
import java.util.*;

public class Main {

    public static   void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken())
                , C = Integer.parseInt(st.nextToken());
        long[] list = new long[S];
        long sum = 0;
        for (int i = 0; i < S; i++) {
            list[i] = Long.parseLong(br.readLine());
            sum += list[i];
        }
        long s = 0,e = sum;
        while (s<e) {
            long mid = (s+e)/2;
            long cnt = 0;
            for (long n:list) cnt+=n/mid;
            if (cnt >= C) s=mid+1;
            else e=mid;
        }
        ans.append(sum-(s-1)*C);
        System.out.println(ans);
    }


}