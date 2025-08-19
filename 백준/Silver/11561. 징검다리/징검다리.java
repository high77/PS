import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            long N = Long.parseLong(br.readLine()), s=0,res =0;
            long e= (long) Math.sqrt((2*N-1));

            while(s<=e){
                long mid=(s+e)/2;
                long sum=  (mid) *(mid+1)/2;
                if(sum<=N){
                    res=Math.max(mid,res);
                    s=mid+1;
                }
                else e=mid-1;
            }
            ans.append(res).append("\n");
        }

        System.out.print(ans);
    }


}
