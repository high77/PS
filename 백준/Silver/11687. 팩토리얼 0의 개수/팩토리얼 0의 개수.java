import java.io.*;

public class Main {

    static int getCnt(int mid){
        int cnt = 0;

        for (int i=5;i<=mid;i*=5) cnt+=(mid/i);
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int M = Integer.parseInt(br.readLine()), s =1,e=M*5;
        boolean flag = false;

        while (s<=e) {
            int mid = (s+e)/2;
            int cnt = getCnt(mid);
            if (cnt>M) e=mid-1;
            else if (cnt==M) {
                e=mid-1;
                flag = true;
            }
            else s=mid+1;
        }
        if (flag) ans.append(s);
        else ans.append(-1);
        System.out.println(ans);
    }

}