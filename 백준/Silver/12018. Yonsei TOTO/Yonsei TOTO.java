import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] list ;
        int[] minList = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());
            list = new int[p];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < p; j++) list[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(list);
            minList[i] = p<l ? 0: list[p-l];
        }
        Arrays.sort(minList);
        for (int n: minList) {
            if (n>M || M==0)break;
            if (n==0) M-=1;
            else M-=n;
            ans++;
        }
        System.out.println(ans);
    }


}
