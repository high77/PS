import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int group = 1;
        StringBuilder ans = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N==0) break;
            String[] names = new String[N];
            List<List<String>> messages = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] inputParts = br.readLine().split(" ");
                names[i] = inputParts[0];
                List<String> messageList = new ArrayList<>();
                for (int j = 1; j < inputParts.length; j++) {
                    messageList.add(inputParts[j]);
                }
                messages.add(messageList);
            }

            // 그룹 처리 시작
            ans.append("Group ").append(group).append("\n");
            boolean hasNasty = false;

            for (int i = 0; i < N; i++) {
                List<String> messageList = messages.get(i);
                for (int j = 0; j < messageList.size(); j++) {
                    if ("N".equals(messageList.get(j))) {
                        int targetIndex = (i - j - 1 + N) % N;
                        ans.append(names[targetIndex]).append(" was nasty about ").append(names[i]).append("\n");
                        hasNasty = true;
                    }
                }
            }

            if (!hasNasty) {
                ans.append("Nobody was nasty\n");
            }

            ans.append("\n");
            group++;
        }

        System.out.print(ans);
    }
}
