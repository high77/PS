import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , B = Integer.parseInt(st.nextToken()), A = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);
        int ans =0, a = A;
        while (ans<N){
            if (A>0){
                B -= list[ans]/2;
                A--;
            }else{
                if (a==0) {
                    B -= list[ans];
                }else{
                    B -= list[ans-a]/2;
                    B -= list[ans]/2;
                }
            }
            if (B<0) break;
            ans++;
        }
        System.out.println(ans);
    }
}