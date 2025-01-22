import java.util.StringTokenizer;
import java.io.*;
public class Main {
    static int N,K,res;
    static int[] words;    

    public static int toBit(String s) {
        int bit = 0;
        for(int i = 4; i<s.length()-4; i++) {
            char c = s.charAt(i);
            bit |= (1 << c - 'a');
        }
        return bit;
    }

    public static void dfs(int k, int m, int start) {
        if(k == K) {
            int tmp = 0;
            for(int word : words) {
                if((m & word) == word) tmp++;
            }
            res = Math.max(res, tmp);
            return;
        }
        for(int i = start; i<26; i++) {
            int bit = (1 << i);
            if((m & bit) == 0) dfs(k + 1, m | bit, i + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        res = 0;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new int[N];
        int mask = 1 | (1 << 'n' - 'a') | (1 << 't' - 'a') | (1 << 'i' - 'a') | (1 << 'c' - 'a');
        for(int i = 0; i<N; i++) {
            String s = br.readLine();
            words[i] = mask | toBit(s);
        }

        if (K==26) ans.append(N);
        else if (K<5) ans.append(0);
        else {
            K-=5;
            dfs(0, mask, 0);
            ans.append(res);
        }
        System.out.println(ans);
    }


}