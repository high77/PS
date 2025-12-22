import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String[] input ;
        while (T-- > 0) {
            int res =0;
            input = br.readLine().split(" ");
            for (String s : input) res += Integer.parseInt(s);
            ans.append(res).append("\n");
        }
        System.out.println(ans);
    }

}