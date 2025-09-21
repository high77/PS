import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> arr = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            arr.add(br.readLine());
            count += arr.get(i).length();
        }
        int blank = m - count;
        if (blank > 0) {
            if (n == 1) {
                StringBuilder one = new StringBuilder();
                for (int i = 0; i < blank; i++) one.append('_');
                arr.set(0, arr.get(0) + one.toString());
            } else {
                int c = blank / (n - 1);
                int k = blank % (n - 1);

                StringBuilder add1Builder = new StringBuilder();
                for (int i = 0; i < c; i++) add1Builder.append('_');
                String add1 = add1Builder.toString();

                for (int j = 0; j < n - 1; j++) {
                    if (k > 0) {
                        char nextFirst = arr.get(j + 1).charAt(0);
                        if (nextFirst <= 'z' && nextFirst >= 'a') {
                            arr.set(j, arr.get(j) + '_');
                            k--;
                        } else if (j >= n - 1 - k) {
                            arr.set(j, arr.get(j) + '_');
                            k--;
                        }
                    }
                    arr.set(j, arr.get(j) + add1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }
        System.out.println(sb);
    }

}
