import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        if (!st.hasMoreTokens()) return;
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        double R = Double.parseDouble(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int ax = Integer.parseInt(st.nextToken());
        int ay = Integer.parseInt(st.nextToken());
        int bx = Integer.parseInt(st.nextToken());
        int by = Integer.parseInt(st.nextToken());
        
        // 1단위 반지름 길이
        double unitR = R / N;
        
        // 1. 원점을 경유하는 경로의 거리
        double distThroughOrigin = (ay + by) * unitR;
        
        // 2. 최소 공통 반지름 궤도를 따라 이동하는 경로의 거리
        int minY = Math.min(ay, by);
        int maxY = Math.max(ay, by);
        int diffX = Math.abs(ax - bx);
        
        // 직선 이동 거리 (반지름 차이)
        double radialDist = (maxY - minY) * unitR;
        // 호(Arc) 이동 거리 (최소 반경 궤도 기준)
        double arcDist = diffX * (Math.PI / M) * (minY * unitR);
        
        double distThroughArc = radialDist + arcDist;
        
        // 두 경로 중 최소값 출력
        System.out.printf("%.14f\n", Math.min(distThroughOrigin, distThroughArc));
    }
}