import java.io.*;
import java.util.*;

public class Main {
    static int[] change(String s){
        int[] list = new int[s.length()];
        int cnt = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), cnt);
                cnt++;
            }
            list[i] = map.get(s.charAt(i));
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine()), ans = 0;
        String[] word = new String[N];
        for (int i = 0; i < N; i++) word[i] = br.readLine();
        int[][] arr = new int[N][word[0].length()];
        for (int i = 0; i < N; i++) arr[i] = change(word[i]);
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int cnt = 0;
                for (int k = 0; k < word[0].length(); k++) {
                    if (arr[i][k] != arr[j][k]) break;
                    cnt++;
                }
                if (cnt == word[i].length()) ans++;
            }
        }
        System.out.println(ans);
    }
}