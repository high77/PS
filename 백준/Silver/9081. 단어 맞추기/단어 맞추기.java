import java.io.*;

public class Main {
    static void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            char[] S = br.readLine().toCharArray();
            int L = S.length - 1;

            int e = L;
            while(e > 0 && S[e - 1] >= S[e]) e--;

            if(e > 0){
                int s = L;
                while(S[e -1] >= S[s]) s--;

                swap(S, e -1, s);
                
                while(e < L){
                    swap(S, e, L);
                    e++;
                    L--;
                }
            }

            for(char c : S) ans.append(c);
            ans.append("\n");
        }
        System.out.println(ans);
    }

}