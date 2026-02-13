import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] hSum = new int[N + 1];
        int[] pSum = new int[N + 1];
        int[] sSum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            char c = br.readLine().charAt(0);
            hSum[i] = hSum[i - 1] + (c == 'H' ? 1 : 0);
            pSum[i] = pSum[i - 1] + (c == 'P' ? 1 : 0);
            sSum[i] = sSum[i - 1] + (c == 'S' ? 1 : 0);
        }

        int maxWins = 0;

        for (int i = 0; i <= N; i++) {
            int firstMax = Math.max(hSum[i], Math.max(pSum[i], sSum[i]));

            int secondMax = Math.max(hSum[N] - hSum[i],
                    Math.max(pSum[N] - pSum[i], sSum[N] - sSum[i]));

            maxWins = Math.max(maxWins, firstMax + secondMax);
        }

        System.out.println(maxWins);
    }
}