import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())
                , M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) set.add(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] words = br.readLine().split(",");
            for (String word : words) {
                set.remove(word);
            }
            ans.append(set.size()).append("\n");
        }
        System.out.println(ans);
    }
}