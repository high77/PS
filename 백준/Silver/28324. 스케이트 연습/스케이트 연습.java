import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        long ans = 1, now =1;
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());

        for (int i=N-2; i>=0; i--) {
            if (list[i] > now) now++;
            else if (list[i] < now) now = list[i];
            ans +=now;
        }

        System.out.println(ans);
    }
}