import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String s = br.readLine();
        int ans = 0, L = 0, S = 0;
        boolean check = true;
        for (int i = 0; check && i < s.length(); i++) {
            check = true;
            switch (s.charAt(i)) {
                case 'L': L++; break;
                case 'S': S++; break;
                case 'R': if(L==0) check =false; else {ans++; L--;} break;
                case 'K': if(S ==0) check =false; else {ans++; S--;} break;
                default: ans++;
            }
        }
        System.out.println(ans);
    }
}