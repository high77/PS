import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans1 =new StringBuilder(), ans2 =new StringBuilder();
        char[] S = br.readLine().toCharArray();
        int mCnt = 0;
        for (char c : S) {
            if (c=='M') mCnt++;
            else {
                ans1.append(5);
                for (int j = 0; j < mCnt; j++) ans1.append(0);
                mCnt=0;
            }
        }
        for (int i=0;i<mCnt;i++) ans1.append(1);
        mCnt = 0;

        for (char c : S) {
            if (c=='M') mCnt++;
            else {
                for (int j = 0; j < mCnt; j++) {
                    if (j==0) ans2.append(1);
                    else ans2.append(0);
                }
                ans2.append(5);
                mCnt=0;
            }
        }
        for (int j = 0; j < mCnt; j++) {
            if (j==0) ans2.append(1);
            else ans2.append(0);
        }



        System.out.println(ans1);
        System.out.println(ans2);
    }

}