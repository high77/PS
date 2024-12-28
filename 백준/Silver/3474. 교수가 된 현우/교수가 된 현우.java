import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T =Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            if (N<5) ans.append(0);
            else {
                int res = 0;
                for (int i = 5; i <= N; i*=5) res+= N/i;
                ans.append(res);
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }

}
