import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        백준 2698
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < N; tc++) {
            String[] list = br.readLine().split(":");
            String h = Integer.toBinaryString(Integer.parseInt(list[0]))
                    , m = Integer.toBinaryString(Integer.parseInt(list[1]))
                    , s = Integer.toBinaryString(Integer.parseInt(list[2]));
            for (int i=0;i<3;i++) {
                list[i] = Integer.toBinaryString(Integer.parseInt(list[i]));
                int tmp = 6-list[i].length();
                for (int j = 0;j<tmp;j++) list[i] = "0" + list[i];
            }
            for (int i=0;i<6;i++) {
                for (int j =0; j<3;j++) ans.append(list[j].charAt(i));
            }
            ans.append(" ");
            for (int j=0;j<3;j++) ans.append(list[j]);
            ans.append("\n");
        }
        System.out.print(ans);
    }
}
