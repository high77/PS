import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()), A[],B[];
        for(int n=0;n<N;n++) {
            A = new int[4];
            B = new int[4];

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for(int i=0;i<a;i++) A[Integer.parseInt(st.nextToken())-1]++;

            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for(int i=0;i<b;i++) B[Integer.parseInt(st.nextToken())-1]++;

            for(int i=3;i>=0;) {
                if(A[i] == B[i]) {
                    if (i == 0) {
                        ans.append('D');
                        break;
                    }
                    i--;
                }else if(A[i]>B[i]) {
                    ans.append('A');
                    break;
                }
                else if(A[i]<B[i]) {
                    ans.append('B');
                    break;
                }
            }
            ans.append('\n');
        }
        System.out.println(ans);
    }
}