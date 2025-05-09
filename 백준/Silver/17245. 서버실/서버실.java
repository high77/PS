import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine()),s=0,e=0;
        long sum=0;
        int[][] computers = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                computers[i][j] = Integer.parseInt(st.nextToken());
                sum += computers[i][j];
                e = Math.max(e, computers[i][j]);
            }
        }
        while (s<e){
            int mid = (s+e)/2;
            long cnt =0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) cnt+=Math.min(computers[i][j],mid);
            }
            if (cnt*2>=sum) e = mid;
            else s=mid+1;
        }

        System.out.println(e);
    }
}