import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int ans =0;
        int N = Integer.parseInt(br.readLine());
        int L = Integer.toString(N).length();
        for (int i = 0; i < L; i++) {
            int n = N%10;
            N/=10;
            if (n>4) ans+= (int) ((n-1)*Math.pow(9,i));
            else  ans+= (int) (n*Math.pow(9,i));
        }
        System.out.println(ans);

    }
}
