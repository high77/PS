import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> Info = new ArrayList<>();
        int colorSize[] = new int[N+1];
        for(int i =0 ;i < N ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            Info.add(new int[]{x,y});
            colorSize[y]++;
        }
        Collections.sort(Info, (a,b)->a[1] == b[1] ? a[0]-b[0] : a[1]-b[1]);
        long ans = 0;

        for(int i = 0 ;i < Info.size() ;i++){
            if (colorSize[Info.get(i)[1]] > 0) {
                int l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
                int ldx = i-1, rdx = i+1;
                if(ldx >= 0 && Info.get(ldx)[1] == Info.get(i)[1]) l = Info.get(i)[0]-Info.get(ldx)[0];
                if(rdx < Info.size() && Info.get(rdx)[1] == Info.get(i)[1]) r = Info.get(rdx)[0] - Info.get(i)[0];
                int v = Math.min(l,r);
                ans += v != Integer.MAX_VALUE ? v : 0;
            }
        }
        System.out.println(ans);

    }


}

