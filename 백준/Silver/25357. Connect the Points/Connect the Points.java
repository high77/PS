import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] x = new int[3];
        int[] y = new int[3];
        
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        // 중앙값을 찾기 위해 배열 복사 후 정렬
        int[] sortedX = x.clone();
        int[] sortedY = y.clone();
        Arrays.sort(sortedX);
        Arrays.sort(sortedY);
        
        int mx = sortedX[1]; // X좌표 중앙값
        int minY = sortedY[0];
        int maxY = sortedY[2];
        
        List<String> segments = new ArrayList<>();
        
        // 1. 공통 수직 선분 추가 (길이가 0보다 클 경우)
        if (minY != maxY) {
            segments.add(mx + " " + minY + " " + mx + " " + maxY);
        }
        
        // 2. 각 점에서 수직 선분을 향해 긋는 수평 선분 추가
        for (int i = 0; i < 3; i++) {
            if (x[i] != mx) {
                segments.add(x[i] + " " + y[i] + " " + mx + " " + y[i]);
            }
        }
        
        // 3. 결과 출력
        System.out.println(segments.size());
        for (String seg : segments) {
            System.out.println(seg);
        }
    }
}