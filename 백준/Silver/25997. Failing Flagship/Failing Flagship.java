import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String X = st.nextToken(), Y = st.nextToken();
        double angleX = getAngle(X), angleY = getAngle(Y);
        
        double diff = Math.abs(angleX - angleY);
        // 최단 회전 각도 계산 (360도 보정)
        System.out.printf("%.14f\n", Math.min(diff, 360.0 - diff));
    }

    static double getAngle(String dir) {
        // 단일 문자 기본 방향 예외 처리
        if (dir.equals("N")) return 0.0;
        if (dir.equals("E")) return 90.0;
        if (dir.equals("S")) return 180.0;
        if (dir.equals("W")) return 270.0;

        int len = dir.length();
        String base = dir.substring(len - 2);
        
        double angle = 0.0, step = 45.0; // 기본 이동 폭은 45도
        
        // 사분면 기준점 설정
        if (base.equals("NE")) angle = 45.0;
        else if (base.equals("SE")) angle = 135.0;
        else if (base.equals("SW")) angle = 225.0;
        else if (base.equals("NW")) angle = 315.0;

        // 문자열 끝에서부터 역방향으로 1/2씩 쪼개며 각도 보정
        for (int i = len - 3; i >= 0; i--) {
            step /= 2.0; // 탐색 구간을 절반으로 줄임
            char c = dir.charAt(i);
            
            if (base.equals("NE")) {
                if (c == 'N') angle -= step; // 북쪽(0도)을 향해 각도 감소
                else angle += step;          // 동쪽(90도)을 향해 각도 증가
            } else if (base.equals("SE")) {
                if (c == 'S') angle += step; // 남쪽(180도)을 향해 각도 증가
                else angle -= step;          // 동쪽(90도)을 향해 각도 감소
            } else if (base.equals("SW")) {
                if (c == 'S') angle -= step; // 남쪽(180도)을 향해 각도 감소
                else angle += step;          // 서쪽(270도)을 향해 각도 증가
            } else if (base.equals("NW")) {
                if (c == 'N') angle += step; // 북쪽(360도/0도)을 향해 각도 증가
                else angle -= step;          // 서쪽(270도)을 향해 각도 감소
            }
        }
        return angle;
    }
}