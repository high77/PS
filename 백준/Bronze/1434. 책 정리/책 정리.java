import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken());

        int []box = new int [N];
        int []book = new int [M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) box[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< M; i++) book[i] = Integer.parseInt(st.nextToken());
        int idx =0,ans=0;
        for(int i = 0; i< M; i++){
            while(true){
                if(box[idx]<book[i]) idx++;
                else{
                    box[idx] -= book[i];
                    break;
                }
            }
        }

        for(int i=0;i<N;i++)ans += box[i];

        System.out.println(ans);
    }
}