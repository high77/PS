import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int getScore(String a, String b) {
        int score = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) score++;
        }

        return score;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int N = Integer.parseInt(br.readLine()),res=Integer.MAX_VALUE;
            boolean flag = false;
            String[] list = br.readLine().split(" ");
            HashMap<String,Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                map.put(list[i], map.getOrDefault(list[i], 0) + 1);
                if (map.get(list[i])==3) {
                    flag = true;
                    break;
                }
            }
            if (flag) ans.append(0);
            else {
                for (int i = 0; i < N; i++) {
                    for (int j = i+1; j < N; j++) {
                        for (int k = j+1; k < N; k++) {
                            int cnt = getScore(list[i],list[j])+getScore(list[j],list[k])+getScore(list[i],list[k]);
                            res = Math.min(res,cnt);
                            if (res==0) break;
                        }
                    }
                }
                ans.append(res);
            }
            ans.append("\n");
        }

        System.out.println(ans);
    }
}