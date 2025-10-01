import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            int res=0,tmp;
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                tmp =0;
                for (int j = 0; j < input.length; j++) {
                    tmp+=input[j].length()+1;
                    if (res<=tmp) {
                        res=tmp;
                        break;
                    }
                }
            }
            ans.append(res).append("\n");
        }

        System.out.println(ans);
    }
}
