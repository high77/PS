import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        String[] list = new String[N];

        for (int i = 0; i < N; i++) list[i] = br.readLine();
        
        Arrays.sort(list);

        int ans = 0;
        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            int num = Arrays.binarySearch(list, tmp);
            if (num < 0) num = -(num + 1);
            if (num < N && list[num].startsWith(tmp)) ans++;
        }
        System.out.println(ans);
    }
}
