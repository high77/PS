import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] position = br.readLine().split(" ");
        int X = Integer.parseInt(position[0]);
        int Y = Integer.parseInt(position[1]);
        int K = Integer.parseInt(br.readLine());
        char[] route = br.readLine().toCharArray();

        Map<Character, int[]> direction = Map.of(
                'I', new int[]{1, 0}, 'S', new int[]{0, 1},
                'Z', new int[]{-1, 0}, 'J', new int[]{0, -1}
        );

        int curX = 0, curY = 0;
        TreeSet<Integer> heardTimes = new TreeSet<>();

        if (Math.abs(curX - X) <= 1 && Math.abs(curY - Y) <= 1) {
            heardTimes.add(0); // 0초도 들을 수 있는 경우 추가
        }

        for (int t = 0; t < K; t++) {
            int[] move = direction.get(route[t]);
            curX += move[0];
            curY += move[1];

            
            if (Math.abs(curX - X) <= 1 && Math.abs(curY - Y) <= 1) {
                heardTimes.add(t + 1); // 0-based index이므로 +1
            }
        }

        if (heardTimes.isEmpty()) {
            sb.append("-1\n");
        } else {
            for (int time : heardTimes) {
                sb.append(time).append("\n");
            }
        }

        System.out.print(sb);
    }
}
