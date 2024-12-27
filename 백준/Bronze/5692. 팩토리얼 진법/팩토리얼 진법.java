import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            int n = 0;
            int cnt = 0;
            for(int i = N ; i > 0; i /= 10) {
                int num = i % 10;
                n += num * f(++cnt);
            }
            ans.append(n+"\n");
        }
        System.out.println(ans);
    }

    private static int f(int cnt) {
        if(cnt == 1) return 1;
        return cnt * f(cnt - 1);
    }
}
