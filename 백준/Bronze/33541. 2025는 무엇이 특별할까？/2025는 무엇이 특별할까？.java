import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        
        int answer = -1;
        for (int i = X + 1; i <= 9999; i++) {
            int front = i / 100;
            int back = i % 100;
            int sum = front + back;
            
            if (sum * sum == i) {
                answer = i;
                break;
            }
        }
        
        System.out.println(answer);
    }
}
