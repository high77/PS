import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            boolean flag = false;
            int k = Integer.parseInt(br.readLine());
            String[] list = new String[k];
            for(int i = 0; i < k; i++) list[i] = br.readLine();

            loop:
            for(int i = 0; i < k; i++) {
                for(int j = 0; j < k; j++) {
                    if(i == j) continue;
                    String s = list[i] + list[j];
                    String rev = new StringBuilder(s).reverse().toString();
                    if(s.equals(rev)) {
                        ans.append(s +"\n");
                        flag = true;
                        break loop;
                    }
                }
            }
            if(!flag) ans.append(0+"\n");
        }

        System.out.println(ans);
    }
}