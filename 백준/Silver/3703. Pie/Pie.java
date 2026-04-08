import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), F = Integer.parseInt(st.nextToken());
            
            double[] V = new double[N];
            double maxV = 0;
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int r = Integer.parseInt(st.nextToken());
                V[i] = Math.PI * r * r;
                if (V[i] > maxV) maxV = V[i];
            }
            
            double left = 0, right = maxV;
            
            // 100번의 고정 이분 탐색으로 부동소수점 무한 루프 원천 차단 및 극한의 정밀도 확보
            for (int iter = 0; iter < 100; iter++) {
                double mid = (left + right) / 2;
                int count = 0;
                
                for (int i = 0; i < N; i++) count += (int) (V[i] / mid);
                
                if (count >= F + 1) left = mid;
                else right = mid;
            }
            
            sb.append(String.format("%.4f\n", right));
        }
        
        System.out.print(sb);
    }
}