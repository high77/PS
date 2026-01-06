import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        char[] S = br.readLine().toCharArray();
        if (S.length<2){
            ans.append("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
            System.out.println(ans);
            return;
        }
        boolean flag = true;
        int diff = S[1]-S[0];
        for (int i = 2; i < S.length; i++){
            int curDiff = S[i]-S[i-1];
            if (curDiff!=diff) {
                flag = false;
                break;
            }
        }
        if (flag) ans.append("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
        else ans.append("흥칫뿡!! <(￣ ﹌ ￣)>");
        System.out.println(ans);
    }
}