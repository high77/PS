import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),K =Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());

        int ans = 0,sum=0;
        for (int i = 0; i < K; i++) sum+=list[i];

        ans = sum;

        for (int i=K; i<N+K-1; i++) {
            sum+= list[i%N]-list[(i-K)%N];
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}