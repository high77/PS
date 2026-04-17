import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        long C = Long.parseLong(st.nextToken()), D = Long.parseLong(st.nextToken());
        
        long K = Long.parseLong(br.readLine().trim());

        if (K == 0) {
            long nT = (A + B - 1) / B;
            
            // 볼록 함수의 양 끝점 검사: n=1
            if (nT > 1 && D - B >= C) {
                System.out.println(-1);
                return;
            }
            // 볼록 함수의 양 끝점 검사: n=nT-1 (오버플로우 방지를 위한 BigInteger 적용)
            if (nT > 2) {
                BigInteger nMinus1 = BigInteger.valueOf(nT - 1);
                BigInteger diff = BigInteger.valueOf(D - B);
                if (nMinus1.multiply(diff).compareTo(BigInteger.valueOf(C)) >= 0) {
                    System.out.println(-1);
                    return;
                }
            }
            // 집에 도착했을 때 돌돌이도 집에 도착했는지 검사
            BigInteger nTBig = BigInteger.valueOf(nT), DBig = BigInteger.valueOf(D);
            BigInteger limit = BigInteger.valueOf(A).add(BigInteger.valueOf(C));
            if (nTBig.multiply(DBig).compareTo(limit) >= 0) {
                System.out.println(-1);
                return;
            }
            
            System.out.println(nT);
            
        } else {
            // 속도가 1 이상 유지되는 최대 스텝 수 계산
            long m = (B - 1) / K + 1;
            
            if (getST(m, B, K) < A) {
                System.out.println(-1);
                return;
            }

            // 이분 탐색으로 집에 도달하는 최소 스텝 수 탐색
            long low = 1, high = m, nT = m;
            while (low <= high) {
                long mid = (low + high) / 2;
                if (getST(mid, B, K) >= A) {
                    nT = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // K > 0 인 경우에는 최대 스텝 수가 10^9를 넘지 않으므로 long 타입으로 완벽 호환
            if (nT > 1 && D - B >= C) {
                System.out.println(-1);
                return;
            }
            if (nT > 2) {
                long ST_prev = getST(nT - 1, B, K), SD_prev = (nT - 1) * D;
                if (SD_prev - ST_prev >= C) {
                    System.out.println(-1);
                    return;
                }
            }
            if (nT * D >= A + C) {
                System.out.println(-1);
                return;
            }
            
            System.out.println(nT);
        }
    }

    // n 스텝 동안 토카가 이동한 총 거리 (중간 연산 오버플로우 방지식 적용)
    static long getST(long n, long B, long K) {
        long term1 = n * B, term2;
        if (n % 2 == 0) {
            term2 = K * (n / 2) * (n - 1);
        } else {
            term2 = K * n * ((n - 1) / 2);
        }
        return term1 - term2;
    }
}