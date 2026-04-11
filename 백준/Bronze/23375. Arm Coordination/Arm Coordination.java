import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken()), y = Long.parseLong(st.nextToken());
        long r = Long.parseLong(br.readLine());

        // 반시계 방향(Counter-clockwise) 출력
        System.out.println((x - r) + " " + (y - r));
        System.out.println((x + r) + " " + (y - r));
        System.out.println((x + r) + " " + (y + r));
        System.out.println((x - r) + " " + (y + r));
    }
}