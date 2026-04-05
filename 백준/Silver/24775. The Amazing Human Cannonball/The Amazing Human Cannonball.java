import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        final double G = 9.81;
        final double MARGIN = 1.0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double v0 = Double.parseDouble(st.nextToken()), thetaDeg = Double.parseDouble(st.nextToken())
                    , x1 = Double.parseDouble(st.nextToken()), h1 = Double.parseDouble(st.nextToken())
                    , h2 = Double.parseDouble(st.nextToken()), thetaRad = Math.toRadians(thetaDeg);

            double t = x1 / (v0 * Math.cos(thetaRad));

            double y = (v0 * t * Math.sin(thetaRad)) - (0.5 * G * t * t);

            if (y >= h1 + MARGIN && y <= h2 - MARGIN) ans.append("Safe\n");
            else ans.append("Not Safe\n");
        }

        System.out.println(ans);
    }
}