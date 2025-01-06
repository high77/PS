import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[35];
        int[] y = new int[35];
        int res = 0;

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            x[i] = Integer.parseInt(input[0]);
            y[i] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int area = Math.abs(
                            x[i] * y[j] + x[j] * y[k] + x[k] * y[i]
                                    - x[j] * y[i] - x[k] * y[j] - x[i] * y[k]
                    );
                    res = Math.max(res, area);
                }
            }
        }

        if (res % 2 == 1) {
            ans.append(res / 2+".5");
        } else {
            ans.append(res / 2+".0");
        }

        System.out.println(ans);
    }
}