import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        if ((input[0]-'0')+(input[4]-'0')==input[8]-'0') System.out.println("YES");
        else System.out.println("NO");
    }

}