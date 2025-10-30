import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), i =-1;

        String str1="", str2 = "";
        for(i=0;i<N;i++) str1 = str1 + br.readLine();
        for(i=0;i<N;i++) str2 = str2 + br.readLine();
        boolean chk = false;
        for(i=0;i<N*M*2;i++) if(str2.charAt(i)!=str1.charAt(i/2)) {
            chk = true;
            break;
        }
        System.out.println(chk?"Not Eyfa":"Eyfa");

    }
}