import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()) , ans =0;
        int [] days = new int[] {0,0,31,28,31,30,31,30,31,31,30,31,30,31};
        String [] day = { "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};
        for(int i=0;i<=M;i++) ans+=days[i];
        ans+=D;
        System.out.print(day[ans%7]);
    }


}
