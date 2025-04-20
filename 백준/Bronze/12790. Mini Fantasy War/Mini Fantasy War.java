import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(bf.readLine()); 
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int[] ability = new int[8];	
            
            for(int j=0; j<8; j++) ability[j] = Integer.parseInt(st.nextToken());
            
            for(int j=0; j<4; j++) ability[j] += ability[j+4];
            

            ability[0] = (ability[0] < 1) ? 1 : ability[0];
            ability[1] = (ability[1] < 1) ? 1 : ability[1];
            ability[2] = (ability[2] < 0) ? 0 : ability[2];

            int result = ability[0] + (ability[1]*5) + (ability[2]*2) + (ability[3]*2);
            ans.append(result+"\n");
        }
        System.out.println(ans);
    }

}