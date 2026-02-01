import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 용량
            int N = Integer.parseInt(st.nextToken()); // 지점 수

            int[] x = new int[N];
            int[] w = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                w[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(solve(W, N, x, w)).append('\n');
        }
        System.out.print(sb);
    }

    private static long solve(int capacity, int n, int[] x, int[] w) {
        long totalDist = 0;
        int currentWeight = 0;
        int previousPos = 0; // 트럭의 출발 위치 (0)

        for (int i = 0; i < n; i++) {
            // 1. 다음 지점으로 이동
            totalDist += (x[i] - previousPos);

            // 2. 싣기 전 용량 초과 체크
            if (currentWeight + w[i] > capacity) {
                // 현재 위치(x[i])에서 쓰레기장(0)을 찍고 다시 돌아옴(x[i])
                totalDist += (x[i] * 2);
                currentWeight = 0;
            }

            // 3. 쓰레기 적재
            currentWeight += w[i];

            // 4. 실은 후 용량이 꽉 찼는지 체크
            if (currentWeight == capacity) {
                // 마지막 지점이 아니라면 비우러 가야 함 (x[i] -> 0)
                if (i < n - 1) {
                    totalDist += x[i];
                    currentWeight = 0;
                    previousPos = 0; // 트럭이 0에 있으므로 다음 이동은 0부터 시작
                    continue; // 아래의 previousPos = x[i] 갱신을 건너뜀
                }
            }

            // 트럭은 현재 x[i]에 머물러 있음
            previousPos = x[i];
        }

        // 모든 작업이 끝나고 마지막 위치에서 쓰레기장(0)으로 복귀
        totalDist += previousPos;

        return totalDist;
    }
}
