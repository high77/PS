import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        
        long minSurface = Long.MAX_VALUE;
        long bestA = 0, bestB = 0, bestC = 0;
        
        // a <= b <= c 순서로 제한하여 중복 탐색 방지 및 최적화
        for (long a = 1; a * a * a <= n; a++) {
            if (n % a != 0) continue;
            
            long rem = n / a;
            for (long b = a; b * b <= rem; b++) {
                if (rem % b != 0) continue;
                
                long c = rem / b;
                long surface = 2 * (a * b + b * c + c * a);
                
                if (surface < minSurface) {
                    minSurface = surface;
                    bestA = a;
                    bestB = b;
                    bestC = c;
                }
            }
        }
        
        System.out.println(bestA + " " + bestB + " " + bestC);
    }
}