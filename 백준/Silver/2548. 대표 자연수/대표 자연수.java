import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine()), ans =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for(int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);
        System.out.println(list[(N-1)/2]);
    }
}