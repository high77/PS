import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans  = new StringBuilder();
        long ans = 0;
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        int[] cnt = new int[60001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        for (int i=0;i<N;i++){
            ans+=cnt[30000-list[i]];
            for (int j=0;j<i;j++)cnt[30000+list[i]+list[j]]++;
        }
        System.out.println(ans);
    }
}

