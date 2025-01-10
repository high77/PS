import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
            map.put(list[i], map.getOrDefault(list[i], 0) + 1);
        }
        for (int i = 0; i < N; i++) {
            int res = 0;
            for (int j=1;j<=Math.sqrt(list[i]);j++){
                if (list[i]%j!=0) continue;
                if (map.containsKey(j)) res+=map.get(j);
                if (list[i]/j==j) continue;
                if (map.containsKey(list[i]/j)) res+=map.get(list[i]/j);
            }
            ans.append(res-1+"\n");
        }
        System.out.println(ans);
    }
}