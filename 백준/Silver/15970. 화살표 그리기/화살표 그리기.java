import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int ans;
    static int[] arr = new int[100000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }
        length();
        System.out.print(ans);
    }
    static int find(int x){
        int min = 100000;
        for(int i=0; i<arr.length; i++){
            if(i != x && arr[x] == arr[i])
                if(min >= Math.abs(x-i))
                    min = Math.abs(x-i); 
        }
        return min;
    }
    static void length(){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0)
                continue;
            ans += find(i);
        }
    }
}