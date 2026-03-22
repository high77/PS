import java.io.*;
import java.util.*;

public class Main {
    // 변환된 좌표계(u, v)를 저장하는 클래스
    static class Gem implements Comparable<Gem> {
        long u, v;

        public Gem(long u, long v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public int compareTo(Gem o) {
            if (this.u != o.u) {
                return Long.compare(this.u, o.u);
            }
            return Long.compare(this.v, o.v);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long r = Long.parseLong(st.nextToken());

        // w와 h는 로직상 좌표 내부에 보석이 주어진다는 전제가 있으므로 생략 가능합니다.
        long w = Long.parseLong(st.nextToken());
        long h = Long.parseLong(st.nextToken());

        Gem[] gems = new Gem[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            // 좌표 변환 수행
            gems[i] = new Gem(y - r * x, y + r * x);
        }

        // u 기준 오름차순 정렬
        Arrays.sort(gems);

        long[] dp = new long[n];
        int len = 0;

        // v 값들에 대해 최장 비내림차순 부분 수열(LNDS) 계산
        for (int i = 0; i < n; i++) {
            long val = gems[i].v;
            int left = 0;
            int right = len;

            // Upper Bound 이분 탐색 (동일한 v값도 수열 연장이 가능하도록 허용)
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (dp[mid] <= val) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            dp[left] = val;
            if (left == len) {
                len++;
            }
        }

        System.out.println(len);
    }
}