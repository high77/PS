import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 변환 규칙들을 담을 스택
        Stack<Map<String, String>> transformStack = new Stack<>();

        // 초기 상태: North->North, South->South 등 자기 자신으로 매핑
        Map<String, String> currentMap = new HashMap<>();
        currentMap.put("North", "North");
        currentMap.put("South", "South");
        currentMap.put("East", "East");
        currentMap.put("West", "West");
        transformStack.push(currentMap);

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            if (line.startsWith("Move")) {
                String dir = line.substring(5);
                System.out.println(transformStack.peek().get(dir));

            } else if (line.startsWith("Change")) {
                // "Change North to South" 형식
                String[] parts = line.split(" ");
                String from = parts[1];
                String to = parts[3];

                Map<String, String> nextMap = new HashMap<>(transformStack.peek());
                nextMap.put(from, to);
                transformStack.push(nextMap);

            } else if (line.startsWith("Get rid of")) {
                String[] parts = line.split(" ");
                int n = Integer.parseInt(parts[4]);

                for (int i = 0; i < n && transformStack.size() > 1; i++) {
                    transformStack.pop();
                }
            }
        }
    }
}