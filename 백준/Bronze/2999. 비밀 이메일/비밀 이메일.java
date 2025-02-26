import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        char[] S = br.readLine().toCharArray();
        int L = S.length, R=0,C=0;
        for (int i = 1; i*i <= L; i++) {
            if (L%i==0){
                R=i;
                C=L/i;
            }
        }

        char[][] arr = new char[R][C];
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) arr[j][i] = S[i*R+j];
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) ans.append(arr[i][j]);
        }
        System.out.println(ans);
    }
}
