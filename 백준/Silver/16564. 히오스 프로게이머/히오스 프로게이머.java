import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 입력 값 리스트
        List<Integer> x = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x.add(Integer.parseInt(br.readLine()));
        }

        // 내림차순 정렬
        x.sort(Collections.reverseOrder());

        int nest = 1;
        while (k > 0 && x.size() > 1) {
            int diff = x.get(x.size() - 2) - x.get(x.size() - 1);
            int cost = diff * nest;

            if (cost <= k) {
                k -= cost;
                nest++;
                x.remove(x.size() - 1);
            } else {
                break;
            }
        }

        // 마지막 값에 나눠서 분배
        int lastIndex = x.size() - 1;
        x.set(lastIndex, x.get(lastIndex) + k / nest);

        System.out.println(x.get(lastIndex));
    }
}
