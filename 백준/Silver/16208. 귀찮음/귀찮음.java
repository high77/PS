import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            sum += list[i];
        }
        Arrays.sort(list);
        long ans = 0;
        for (int n:list) {
            sum-=n;
            ans += sum*n;
        }
        System.out.println(ans);
    }
}