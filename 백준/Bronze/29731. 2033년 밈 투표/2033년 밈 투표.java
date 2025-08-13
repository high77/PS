import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] list = { "Never gonna give you up",
                "Never gonna let you down",
                "Never gonna run around and desert you",
                "Never gonna make you cry",
                "Never gonna say goodbye",
                "Never gonna tell a lie and hurt you",
                "Never gonna stop"};
        int a = Integer.valueOf(br.readLine());
        String result = "";
        int cnt = 0;
        for(int i = 0; i<a; i++){
            String b = br.readLine();
            for(int j = 0; j<7;j++){
                if(b.equals(list[j])){
                    cnt++;
                    break;
                }
            }
        }
        if(cnt == a) System.out.println("No");
        else System.out.println("Yes");
    }
}