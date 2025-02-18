import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        char[] S = br.readLine().toCharArray();
        int[] prefix = new int[S.length+1];
        int res =0;
        for (int i = 1; i <= S.length; i++) prefix[i] = prefix[i-1] + (S[i-1]-'0');
        for (int len=2;len<=S.length; len+=2) {
            for (int s=0; s<=S.length-len; s++) {
                int mid = s+len/2;
                int left = prefix[mid]-prefix[s];
                int right = prefix[s+len]-prefix[mid];
                if (left==right) res = len;
            }
        }
        System.out.println(res);



        System.out.println(ans);
    }
}
