import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int candy = 0;
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            char[][] arr = new char[r][c];
            for(int j = 0; j < r; j++) {
                String box = br.readLine();
                for(int k = 0; k < c; k++) arr[j][k] = box.charAt(k);
            }
            for(int j = 0; j < r; j++) {
                for(int k = 0; k < c; k++) {
                    if(k < c-2 && arr[j][k] == '>' && arr[j][k+1] == 'o' && arr[j][k+2] == '<') candy++;
                    if(j < r-2 && arr[j][k] == 'v' && arr[j+1][k] == 'o' && arr[j+2][k] == '^') candy++;
                }
            }
            ans.append(candy).append("\n");
        }
        System.out.println(ans);
    }
}