import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] S = br.readLine().toCharArray();
        int ans =1;

        for (int i = 0; i < S.length; i++) {
            if (i==0) {
                if (S[i]=='c') ans*=26;
                else ans*=10;
            }else {
                if (S[i]==S[i-1]) {
                    if (S[i]=='c') ans*=25;
                    else ans*=9;
                }
                else {
                    if (S[i]=='c') ans*=26;
                    else ans*=10;
                }
            }
        }

        System.out.println(ans);
    }
}