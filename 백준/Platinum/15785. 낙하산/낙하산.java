import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        double g = Double.parseDouble(st.nextToken());
        double a = Double.parseDouble(st.nextToken());
        double f = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double Sy = Double.parseDouble(st.nextToken());
        double Sx = Double.parseDouble(st.nextToken());
        int Ex = Integer.parseInt(st.nextToken());

        double[][] adj = new double[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                adj[i][j] = Math.abs(i - j) / f;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int Xp = Integer.parseInt(st.nextToken());
            double Sp = Double.parseDouble(st.nextToken());

            for (int j = 0; j <= N; j++) {
                double time = Math.abs(Xp - j) / Sp;
                if (time < adj[Xp][j]) {
                    adj[Xp][j] = time;
                }
            }
        }

        double[] dist = new double[N + 1];
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[Ex] = 0;
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            int u = -1;
            double minDist = Double.MAX_VALUE;

            for (int j = 0; j <= N; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    u = j;
                }
            }
            if (u == -1) break;
            visited[u] = true;

            for (int v = 0; v <= N; v++) {
                if (!visited[v]) {
                    double cost = adj[v][u]; // 원본 그래프 기준 v에서 u로 가는 간선
                    if (dist[u] + cost < dist[v]) {
                        dist[v] = dist[u] + cost;
                    }
                }
            }
        }

        double minTotalTime = Double.MAX_VALUE;

        for (int x = 0; x <= N; x++) {
            double d = Math.abs(Sx - x);
            double h = (g * d) / (2.0 * a); // 해당 지점까지 수평 이동하기 위한 최소 고도

            if (h <= Sy) {
                double fallTime = (Sy / g) + (d / (2.0 * a));
                double totalTime = fallTime + dist[x];

                if (totalTime < minTotalTime) {
                    minTotalTime = totalTime;
                }
            }
        }

        System.out.printf("%.8f\n", minTotalTime);
    }
}