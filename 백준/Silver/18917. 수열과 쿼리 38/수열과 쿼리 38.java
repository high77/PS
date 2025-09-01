import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        long sum = 0, xor = 0;

        for(int i = 0; i< N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if(type==1) {
                long num = Long.parseLong(st.nextToken());

                sum+=num;
                xor = xor^num;
            }

            else if(type==2) {
                long num = Long.parseLong(st.nextToken());

                sum-=num;
                xor = xor^num;
            }
            else if(type==3) ans.append(sum+"\n");
            else ans.append(xor+"\n");

        }

        System.out.println(ans);
    }
}