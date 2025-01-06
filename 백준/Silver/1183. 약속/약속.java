import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i] = Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken());
        }
        if (N%2==1) ans.append(1);
        else {
            Arrays.sort(list);
            ans.append(list[N/2]-list[N/2-1]+1);
        }
        System.out.println(ans);
    }
}