import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        // 코드 1 실행 횟수: n번째 피보나치 수
        long count1 = fiboMatrix(n);

        // 코드 2 실행 횟수: n - 2 (단, n이 5 이상이므로 항상 양수)
        long count2 = (n - 2) % MOD;

        System.out.println(count1 + " " + count2);
    }

    // 행렬 거듭제곱을 이용한 피보나치 계산 O(log N)
    static long fiboMatrix(long n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        long[][] res = {{1, 0}, {0, 1}}; // 단위 행렬
        long[][] base = {{1, 1}, {1, 0}};

        while (n > 0) {
            if (n % 2 == 1) res = multiply(res, base);
            base = multiply(base, base);
            n /= 2;
        }
        // F_n은 결과 행렬의 [0][1] 또는 [1][0] 위치에 해당
        return res[0][1];
    }

    static long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return c;
    }
}