import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String M = br.readLine();
        int K = Integer.parseInt(br.readLine());

        boolean allZero = true;
        for (int i = 0; i < N; i++) {
            if (M.charAt(i) == '1') {
                allZero = false;
                break;
            }
        }

        if (allZero) {
            System.out.println("YES");
            return;
        }

        boolean possible = true;
        for (int i = 0; i < K && i < N; i++) {
            if (M.charAt(N - 1 - i) == '1') {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }
}