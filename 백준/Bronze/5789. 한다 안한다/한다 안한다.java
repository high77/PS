import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] S = br.readLine().toCharArray();
            ans.append("Do-it");
            if (S[S.length/2-1]!=S[S.length/2])ans.append("-Not");
            ans.append("\n");
        }
        System.out.println(ans);
    }

}