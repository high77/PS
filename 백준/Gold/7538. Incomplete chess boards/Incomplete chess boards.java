import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
                c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());

            // 두 좌표의 합의 홀짝성(색상)이 다르면 1, 같으면 0
            int ans = ((a + b) % 2 != (c + d) % 2) ? 1 : 0;
            sb.append("Scenario #").append(i).append(":\n").append(ans).append("\n\n");
        }
        
        System.out.print(sb);
    }
}