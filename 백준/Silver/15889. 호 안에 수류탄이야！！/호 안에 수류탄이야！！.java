import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] coords = new int[N];
        for (int i = 0; i < N; i++) coords[i] = Integer.parseInt(st.nextToken());
        if (N==1){
            ans.append("권병장님, 중대장님이 찾으십니다");
        }else{
            st = new StringTokenizer(br.readLine());
            int[] range = new int[N-1];
            for (int i = 0; i < N-1; i++) range[i] = Integer.parseInt(st.nextToken());
            int nowR = range[0], nowD=0;
            for (int i = 1; i < N-1; i++) {
                int now = nowR + coords[nowD];
                if (now >= coords[i]){
                    if (now < range[i]+coords[i]) {
                        nowR = range[i];
                        nowD = i;
                    }
                }
            }
            if (nowR+coords[nowD]>=coords[N-1]) ans.append("권병장님, 중대장님이 찾으십니다");
            else ans.append("엄마 나 전역 늦어질 것 같아");
        }
        System.out.println(ans);
    }
}
