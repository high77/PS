import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine()), t=1;
        int num= N;
        while(N >9){
            int a= N %10;
            if(a>=5){
                num+=(10-a)*t;
                N +=10;
            }
            else num-=a*t;
            
            t*=10;
            N /=10;
        }
        System.out.print(num);
    }
}