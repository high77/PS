import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , K = Integer.parseInt(st.nextToken());
        double[] list = new double[N];
        double sum =0;
        for (int i = 0; i < N; i++) list[i] = Double.parseDouble(br.readLine());
        Arrays.sort(list);
        for (int i=K;i<N-K; i++) sum+=list[i];
        ans.append(String.format("%.2f",sum/(N-K-K)+1e-8)+"\n");
        for (int i=0;i<K;i++) sum += list[K]+list[N-K-1];
        ans.append(String.format("%.2f",sum/N+1e-8));
        System.out.println(ans);
    }
}
