import java.util.Scanner;

public class Main {
    static final int MAX = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] inputs = new boolean[MAX];

        for (int i = 0; i < MAX; i++) {
            inputs[i] = scanner.nextInt() != 0;
        }
        scanner.close();

        boolean result = inputs[0] || inputs[1];

        for (int i = 0; i < MAX; i++) {
            for (int j = i + 1; j < MAX; j++) {
                if (i == 0 && j == 1) {
                    continue;
                }
                result ^= (inputs[i] || inputs[j]);
            }
        }

        for (int i = 0; i < MAX; i++) {
            for (int j = i + 1; j < MAX; j++) {
                for (int k = j + 1; k < MAX; k++) {
                    result ^= (inputs[i] || inputs[j] || inputs[k]);
                }
            }
        }

        System.out.println(result ? 1 : 0);
    }
}
