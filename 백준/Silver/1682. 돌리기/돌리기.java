import java.io.*;
import java.util.*;

public class Main {
    private static final String START = "12348765";
    private static final int[][] TRANSFORM_TYPE_RULE = {
            {4,5,6,7,0,1,2,3},
            {3,0,1,2,7,4,5,6},
            {0,2,6,3,4,1,5,7},
            {7,1,2,3,4,5,6,0}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] goal = new char[8];
        for (int i = 0; i < 4; i++) goal[i] = st.nextToken().charAt(0);
        for (int i = 7; i >= 4; i--) goal[i] = st.nextToken().charAt(0);
        final String GOAL = new String(goal);

        if (START.equals(GOAL)) {
            System.out.println(0);
            return;
        }

        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(START);
        visited.add(START);
        int moves = 0;
        StringBuilder output = new StringBuilder();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                String cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    StringBuilder next = new StringBuilder();
                    for (int j = 0; j < 8; j++) {
                        next.append(cur.charAt(TRANSFORM_TYPE_RULE[i][j]));
                    }
                    String nextStr = next.toString();
                    if (nextStr.equals(GOAL)) {
                        output.append(moves + 1).append('\n');
                        System.out.print(output);
                        return;
                    }
                    if (visited.add(nextStr)) {
                        queue.add(nextStr);
                    }
                }
            }
            moves++;
        }
    }
}
