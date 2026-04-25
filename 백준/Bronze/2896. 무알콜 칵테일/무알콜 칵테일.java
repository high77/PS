import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double i = Double.parseDouble(st.nextToken());
        double j = Double.parseDouble(st.nextToken());
        double k = Double.parseDouble(st.nextToken());

        // 가장 적게 만들 수 있는 한계 기준점 찾기
        double minRatio = Math.min(a / i, Math.min(b / j, c / k));

        // 정답 출력 (허용 오차 범위 내 출력을 위해 printf 활용)
        System.out.printf("%f %f %f\n", a - (minRatio * i), b - (minRatio * j), c - (minRatio * k));
    }
}