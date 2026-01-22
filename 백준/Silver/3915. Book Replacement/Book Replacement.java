import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 어떤 줄바꿈 상황에서도 다음 숫자를 안전하게 가져오는 함수
    static String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();

        while (true) {
            String sM = next();
            if (sM == null) break;
            int m = Integer.parseInt(sM);
            int c = Integer.parseInt(next());
            int n = Integer.parseInt(next());
            if (m == 0) break;

            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int k = Integer.parseInt(next());
                int[] b = new int[k + 1]; // b[0]은 현재 요청 위치 포인터
                for (int j = 1; j <= k; j++) b[j] = Integer.parseInt(next());
                q.add(b);
            }

            List<Integer>[] dk = new ArrayList[m + 1];
            for (int i = 1; i <= m; i++) dk[i] = new ArrayList<>();
            Map<Integer, Integer> last = new HashMap<>();
            int time = 0;
            long total = 0;

            while (!q.isEmpty()) {
                int[] s = q.poll();
                int id = s[++s[0]];
                last.put(id, ++time);

                // 1. 책 찾기 (Find)
                int found = m + 1;
                for (int i = 1; i <= m; i++) {
                    if (dk[i].contains(id)) {
                        found = i; dk[i].remove((Integer) id);
                        break;
                    }
                }
                total += found;

                // 2. D1 배치 (Return)
                if (dk[1].size() < c) {
                    dk[1].add(id);
                    total += 1;
                } else {
                    int tp = m + 1; // 임시 장소
                    for (int i = 2; i <= m; i++) if (dk[i].size() < c) { tp = i; break; }
                    total += tp;

                    int lru = -1, min = 1000000;
                    for (int b : dk[1]) if (last.get(b) < min) { min = last.get(b); lru = b; }
                    dk[1].remove((Integer) lru);
                    total += 1; // D1에서 꺼냄

                    int mp = m + 1; // LRU 이동
                    for (int i = 2; i <= m; i++) {
                        if (dk[i].size() < (i == tp ? c - 1 : c)) { mp = i; break; }
                    }
                    if (mp <= m) dk[mp].add(lru);
                    total += mp + tp + 1; // 이동 + 임시집기 + D1넣기
                    dk[1].add(id);
                }
                if (s[0] < s.length - 1) q.add(s);
            }
            ans.append(total).append("\n");
        }
        System.out.print(ans);
    }
}