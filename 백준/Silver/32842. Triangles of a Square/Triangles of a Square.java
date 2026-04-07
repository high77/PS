import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()),
                 x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());

        int corners = 0;

        if ((x1 == 0 || x1 == 2024) && (y1 == 0 || y1 == 2024)) corners++;
        if ((x2 == 0 || x2 == 2024) && (y2 == 0 || y2 == 2024)) corners++;

        System.out.println(2 - corners);
    }
}