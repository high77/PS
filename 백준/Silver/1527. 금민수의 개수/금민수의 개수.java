import java.io.*;
import java.util.*;

public class Main {
    
    static int ans = 0;
    
    static void search(int A, int B, long cur){

        if(cur > B) return;
        if(cur >= A) ans++;

        search(A, B, cur * 10 + 4);
        search(A, B, cur * 10 + 7);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

        search(A, B, 0L);
        
        System.out.println(ans);
    }
    

}