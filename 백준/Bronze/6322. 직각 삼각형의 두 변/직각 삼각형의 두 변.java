import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        int N = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()),b = Integer.parseInt(st.nextToken()),
                    c = Integer.parseInt(st.nextToken());
            if (a==0&&b==0&&c==0) break;
            ans.append("Triangle #"+N++).append('\n');
            if (c == -1) {
                ans.append(String.format("c = %.3f\n\n", Math.sqrt(a*a+b*b)));
                continue;
            }

            int tmp = 0;
            if (a == -1) tmp = c * c - b * b;
            else tmp = c * c - a * a;
            if (tmp <= 0) {
                ans.append("Impossible.\n\n");
                continue;
            }

            ans.append((a==-1?"a":"b") + String.format(" = %.3f\n\n", Math.sqrt(tmp)));
        }
        System.out.print(ans);
    }

}
