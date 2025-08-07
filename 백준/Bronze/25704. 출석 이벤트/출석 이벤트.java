import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine()), P = Integer.parseInt(br.readLine());
        int min = P;
        for (int i = 1; i <= 4; i++) {
            if (i*5>N) break;
            switch (i) {
                case 1 : min = Math.min(min, P -500); break;
                case 2 : min = Math.min(min, (int)(P *0.9)); break;
                case 3 : min = Math.min(min, P -2000); break;
                case 4 : min = Math.min(min, (int)(P *0.75)); break;
            }
        }
        System.out.println(Math.max(min,0));
    }
    
}
