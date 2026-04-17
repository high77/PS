import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        
        char[] map = br.readLine().toCharArray();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) continue;
            
            // 도착점에 도달 가능한 경우 즉시 루프 탈출 (최적화)
            if (i == n - 1) break;
            
            if (i + 1 < n && map[i + 1] == '_') visited[i + 1] = true;
            if (i + k < n && map[i + k] == '_') visited[i + k] = true;
        }
        
        System.out.println(visited[n - 1] ? "YES" : "NO");
    }
}