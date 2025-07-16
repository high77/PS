import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a=0,b=0;
        int[] A = new int[10];
        for (int i = 0; i < 10; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            int B = Integer.parseInt(st.nextToken());
            if (A[i]>B) a++;
            else if (A[i]<B) b++;

        }

        if (a==b) ans.append("D");
        else if (a>b) ans.append('A');
        else ans.append('B');                                                   
        System.out.println(ans);


    }
}