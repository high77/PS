import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long B;
    static int[][] A;

    private static int[][] mul(int[][] a, int[][] b) {
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += (long) a[i][k] * b[k][j];
                }
                res[i][j] = (int) (sum % 1000);
            }
        }
        return res;
    }

    private static int[][] pow(int[][] base, long exp) {
        if (exp == 1) {
            int[][] res = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    res[i][j] = base[i][j] % 1000; // 나머지 처리
                }
            }
            return res;
        }
        int[][] half = pow(base, exp / 2);
        int[][] halfSq = mul(half, half);
        if (exp % 2 == 0) {
            return halfSq;
        } else {
            return mul(halfSq, base);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] res = pow(A, B);

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) ans.append(res[i][j]).append(" ");
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
