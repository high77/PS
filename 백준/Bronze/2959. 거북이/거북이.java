import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans =0;
        int[] list = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++)  list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);
        ans = list[0] * list[2];
        System.out.println(ans);
    }
}