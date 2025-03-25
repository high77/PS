import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main { // 전쟁 - 땅따먹기

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            int t = Integer.parseInt(st.nextToken());
            int max = 0;
            Long idx = null;

            for (int j = 0; j < t; j++) {
                long num = Long.parseLong(st.nextToken());

                // HashMap의 compute 사용으로 코드 간결화 및 성능 최적화
                int count = map.compute(num, (k, v) -> v == null ? 1 : v + 1);

                // 과반수 확인
                if (count > t / 2) {
                    idx = num;
                }
            }

            sb.append(idx != null ? idx : "SYJKGW").append("\n");
            map.clear(); // 맵 초기화
        }

        System.out.print(sb);
    }
}
