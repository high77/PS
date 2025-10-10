import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = N; i >=0; i--) {
            if (i>2) {
                ans.append(i).append(" bottles of beer on the wall, ").append(i).append(" bottles of beer.");
                ans.append("\n").append("Take one down and pass it around, ").append(i-1);
                ans.append(" bottles of beer on the wall.");
            }else if (i==2){
                ans.append(i).append(" bottles of beer on the wall, ").append(i).append(" bottles of beer.");
                ans.append("\n").append("Take one down and pass it around, ").append(i-1);
                ans.append(" bottle of beer on the wall.");
            }else if (i==1){
                ans.append(i).append(" bottle of beer on the wall, ").append(i).append(" bottle of beer.");
                ans.append("\n").append("Take one down and pass it around, ");
                ans.append("no more bottles of beer on the wall.");
            }else {
                ans.append("No more bottles of beer on the wall, no more bottles of beer.\n");
                ans.append("Go to the store and buy some more, ").append(N);
                if (N==1) ans.append(" bottle of beer on the wall.");
                else ans.append(" bottles of beer on the wall.");
            }
            ans.append("\n\n");
        }

        System.out.println(ans);
    }
}