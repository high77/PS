import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 각 사람이 지목한 번호를 저장할 배열
        int[] targets = new int[N];
        for (int i = 0; i < N; i++) {
            targets[i] = Integer.parseInt(br.readLine());
        }

        // 방문 여부 체크 및 현재 위치 추적
        boolean[] visited = new boolean[N];
        int current = 0; // 게임은 영기(0번)부터 시작
        int M = 0;       // 지목 횟수 (정수 M)

        while (true) {
            // 보성이를 찾은 경우
            if (current == K) {
                System.out.println(M);
                return;
            }

            // 이미 방문한 곳을 다시 왔다면 사이클이 발생한 것 (보성이가 없음)
            if (visited[current]) {
                System.out.println("-1");
                return;
            }

            // 현재 위치 방문 처리 후 다음 타겟으로 이동
            visited[current] = true;
            current = targets[current];
            M++;
        }
    }
}