import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        HashMap<Character, Character> map = new HashMap<>();
        map.put('.', '.');
        map.put('O', 'O');
        map.put('-', '|');
        map.put('|', '-');
        map.put('/', '\\');
        map.put('\\', '/');
        map.put('^', '<');
        map.put('<', 'v');
        map.put('v', '>');
        map.put('>', '^');
        for (int i = 0; i < N; i++) {
            char[] S = br.readLine().toCharArray();
            for (int j =0; j<M;j++) arr[i][j] = map.get(S[j]);
        }

        for (int i = M-1; i >=0 ; i--) {
            for (int j = 0; j<N;j++) ans.append(arr[j][i]);
            ans.append('\n');
        }
        System.out.println(ans);
    }
}