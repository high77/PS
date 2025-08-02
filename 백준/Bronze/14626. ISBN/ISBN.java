import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String S = br.readLine();

        int check = 0, n = 0;
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(ch != '*') n += i % 2 == 0 ? ch - '0' : (ch - '0') * 3;
            else check = i;
        }

        int res = 0;
        while(true) {
            if(check % 2 == 0) {
                if((n + res) % 10 == 0) {
                    ans.append(res);
                    break;
                }
            }
            else {
                if((n + res * 3) % 10 == 0) {
                    ans.append(res);
                    break;
                }
            }
            res++;
        }
        System.out.println(ans);
    }
}