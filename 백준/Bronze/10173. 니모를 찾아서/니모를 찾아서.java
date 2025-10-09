import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String S ;
        while (!(S=br.readLine()).equals("EOI")){
            S = S.toUpperCase();
            if (S.contains("NEMO")) ans.append("Found");
            else ans.append("Missing");
            ans.append("\n");
        }
        System.out.println(ans);
    }
}