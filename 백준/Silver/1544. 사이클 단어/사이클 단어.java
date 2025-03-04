import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans =0;
        HashSet<String> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (!set.contains(s)) ans++;
            for (int j = 0; j < s.length(); j++) set.add(s.substring(j)+s.substring(0, j));
        }
        System.out.println(ans);
    }
}
