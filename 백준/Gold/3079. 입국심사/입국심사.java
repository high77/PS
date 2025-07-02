import java.io.*;
import java.net.SocketOption;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        long[] list = new long[N];
        for (int i = 0; i < N; i++) list[i] =  Integer.parseInt(br.readLine());
        Arrays.sort(list);
        long s = 0,e= list[0]*M;
        while (s<e){
            long mid = (s+e)/2,sum = 0;
            for (long n:list){
                long cnt=mid/n;
                if (sum>=M)break;
                sum+=cnt;
            }
            if (sum>=M) e= mid;
            else s = mid+1;
        }
        System.out.println(e);
    }
}