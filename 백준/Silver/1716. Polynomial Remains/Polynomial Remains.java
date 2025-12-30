import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        FastReader fr = new FastReader(br);

        while (true) {
            Integer n = fr.nextInt();
            Integer k = fr.nextInt();

            if (n == null || (n == -1 && k == -1)) break;

            int size = Math.max(n, k) + 1;
            int[] coeffs = new int[size];

            for (int i = 0; i <= n; i++) {
                coeffs[i] = fr.nextInt();
            }

            // 다항식 나눗셈 핵심: x^k = -1 이용
            // i가 k보다 크거나 같을 때만 차수 감소 연산 수행
            for (int i = n; i >= k; i--) {
                coeffs[i - k] -= coeffs[i];
                coeffs[i] = 0;
            }

            // 나머지의 유효 차수 결정
            // 나머지는 이론적으로 최대 k-1차 (단, n < k 이면 n차)
            int limit = (n < k) ? n : k - 1;

            // k=0인 경우 x^0+1=2로 나누는 것이므로 나머지는 항상 0차(상수)
            if (k == 0) limit = 0;

            int d = limit;
            while (d > 0 && coeffs[d] == 0) {
                d--;
            }

            // 결과 빌드
            for (int i = 0; i <= d; i++) {
                ans.append(coeffs[i]).append(i == d ? "" : " ");
            }
            ans.append("\n");
        }
        System.out.print(ans);
    }

    // 공백/줄바꿈에 무관하게 정수를 읽기 위한 보조 클래스
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(BufferedReader br) {
            this.br = br;
        }

        public Integer nextInt() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}