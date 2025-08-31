import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String S;

    static int getBallCnt(char c, boolean flag) {
        int cnt = 0;
        if (flag) {
            for (int i=0; i<N; i++) {
                if (c == S.charAt(i)) cnt++;
                else break;
            }
        }else {
            for (int i=N-1; i>=0; i--) {
                if (c == S.charAt(i)) cnt++;
                else break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int R=0,B=0;
        S = br.readLine();

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'R') R++;
            else B++;
        }

        int resR = R-Math.max(getBallCnt('R', false), getBallCnt('R', true))
                , resB = B-Math.max(getBallCnt('B', false), getBallCnt('B', true));

        System.out.println(Math.min(resB, resR));
    }
}