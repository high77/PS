import java.io.*;
import java.util.*;

public class Main {
    static HashSet<Integer> set = new HashSet<>();
    static int N;
    static int[] d = {1,5,10,50};

    static void f(int k, int cnt, int curV) {
        if (k==3) {
            set.add(curV+(d[k]*(N-cnt)));
            return;
        }
        for (int i = 0; i<=N-cnt; i++) f(k+1, cnt +i,curV+(d[k]*i));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        f(0,0,0);
        System.out.print(set.size());
    }
}
