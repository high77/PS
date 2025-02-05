import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans  = new StringBuilder();
        long ans = 0;
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);
        for (int i = 0; i < N-2; i++) {
            if ((list[i]<0 && list[N-1]<0) || (list[i]>0 && list[N-1]>0)) break;
            int s  = i+1 , e = N-1;
            while (s<e){
                int V = list[i] + list[s] + list[e];
                if (V==0){
                    if (list[s]==list[e]) {
                        ans += (e-s+1)*(e-s)/2;
                        break;
                    }
                    int l = 1,r = 1;
                    while (s+1<e && list[s]==list[s+1]) {
                        l++;
                        s++;
                    }
                    while (e-1>s && list[e]==list[e-1]) {
                        r++;
                        e--;
                    }
                    ans+=l*r;
                }
                if (V>0) e--;
                else  s++;
            }
        }
        System.out.println(ans);
    }
}

