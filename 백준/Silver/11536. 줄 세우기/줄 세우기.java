import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] list = new String[N], list1 = new String[N];
        for (int i = 0; i < N; i++) list[i] = list1[i] = br.readLine();
        Arrays.sort(list1);

        boolean flag = true;
        for (int i = 0; i < N; i++) {
            if (!list[i].equals(list1[i])) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("INCREASING");
            return;
        }
        flag = true;
        Arrays.sort(list1, Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            if (!list[i].equals(list1[i])) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("DECREASING");
            return;
        }
        System.out.println("NEITHER");
    }
}

