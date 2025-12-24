import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        String[] list = br.readLine().split(" ");
        String[] circle = br.readLine().split(" ");
        for(int i = 0; i < 4; i++){
            if (list[i].equals(circle[0])) {
                ans = i+1;
                break;
            }
        }

        System.out.println(ans);
    }

}