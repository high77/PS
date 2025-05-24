import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int [3] , b = new int[3] ,c = new int [3];
        for (int i = 0; i < 3; i++) a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) c[i] = Integer.parseInt(st.nextToken());
        b[0] = c[0]-a[2];
        b[1] = c[1]/a[1];
        b[2] = c[2]-a[0];

        for (int i = 0; i < 3; i++) ans.append(b[i]+" ");
        System.out.println(ans);
    }


}
