import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long cnt = Long.parseLong(br.readLine()), ans = 0;

        if(1<= cnt) {
            ans +=5; 										
            if(N !=1 && N !=5) ans +=((cnt -1)*4);			
            else if(N ==1 || N ==5) ans +=((cnt -1)*4*2);

            if(N ==1) ans +=3;								
            else if(N ==5) ans +=7;
            else if(cnt %2==0) ans +=(N -2);
            else if(cnt %2!=0) ans +=(4- N);
        }
        else ans +=(N -1);
        
        System.out.println(ans);
    }
}