import java.io.*;
import java.util.*;

public class Main {

    static boolean f(int[] list,int i){
        for (int n : list) {
            boolean flag = false;
            int s= 0, e = 10*i;
            while (s <= e) {
                int mid = (s + e) / 2;
                int curV = (mid * 1000) / i;
                if (curV < n) s = mid + 1;
                else if (curV > n) e = mid - 1;
                else {
                    flag = true;
                    break;
                }
            }
            if (!flag) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(br.readLine().replace(".",""));
        for (int i = 1; i <= 1000; i++) {
            if (f(list, i)) {
                ans.append(i);
                break;
            }
        }
        System.out.print(ans);
    }
}
