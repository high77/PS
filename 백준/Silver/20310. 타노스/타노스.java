import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        char[] list = br.readLine().toCharArray();
        int[] cnt = new int[2];
        for (char c:list) cnt[c-'0']++;
        for (int i=0;i<2;i++) cnt[i]/=2;
        for (int i=list.length-1;i>=0;i--) {
            if (cnt[0]==0) break;
            if (list[i]=='0') {
                cnt[0]--;
                list[i] = '2';
            }
        }
        for (int i=0;i<list.length;i++) {
            if (cnt[1]==0) break;
            if (list[i]=='1') {
                cnt[1]--;
                list[i] = '2';
            }
        }
        for (char i:list) {
            if (i!='2') ans.append(i);
        }
        System.out.println(ans);
    }
}