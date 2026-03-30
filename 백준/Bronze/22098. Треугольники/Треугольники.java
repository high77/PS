import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        
        int T = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] arr = new long[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            
            int right = 0, acute = 0, obtuse = 0;
            
            // 4개의 선분 중 하나를 제외(skip)하는 방식으로 3개 선택 조합 구현
            for (int skip = 0; skip < 4; skip++) {
                long[] sides = new long[3];
                int idx = 0;
                for (int i = 0; i < 4; i++) {
                    if (i == skip) continue;
                    sides[idx++] = arr[i];
                }
                
                Arrays.sort(sides);
                long a = sides[0];
                long b = sides[1];
                long c = sides[2];
                
                // 퇴화하지 않은(non-degenerate) 삼각형 조건 검사
                if (a + b > c) {
                    long a2b2 = a * a + b * b;
                    long c2 = c * c;
                    
                    if (a2b2 == c2) {
                        right++;
                    } else if (a2b2 > c2) {
                        acute++;
                    } else {
                        obtuse++;
                    }
                }
            }
            sb.append(right).append(" ").append(acute).append(" ").append(obtuse).append("\n");
        }
        System.out.print(sb);
    }
}