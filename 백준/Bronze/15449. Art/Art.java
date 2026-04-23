import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] l = new int[5];
        for (int i = 0; i < 5; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(l);
        
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                for (int k = j + 1; k < 5; k++) {
                    // a + b > c 조건 판별
                    if (l[i] + l[j] > l[k]) count++;
                }
            }
        }
        
        System.out.println(count);
    }
}