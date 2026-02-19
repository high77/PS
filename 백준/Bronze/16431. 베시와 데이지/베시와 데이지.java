import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] b = parse(br.readLine());
        int[] d = parse(br.readLine());
        int[] j = parse(br.readLine());

        // 베시: 체비쇼프 거리 max(|x1-x2|, |y1-y2|)
        int bt = Math.max(Math.abs(b[0] - j[0]), Math.abs(b[1] - j[1]));
        // 데이지: 맨해튼 거리 |x1-x2| + |y1-y2|
        int dt = Math.abs(d[0] - j[0]) + Math.abs(d[1] - j[1]);

        System.out.println(bt < dt ? "bessie" : bt > dt ? "daisy" : "tie");
    }

    static int[] parse(String s) {
        StringTokenizer st = new StringTokenizer(s);
        return new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    }
}