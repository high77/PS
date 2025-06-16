import java.io.*;

public class Main{
    static int[] alphabet = new int[27];
    static int res;
    static int N;

    static void dfs(int k,int pre){
        if (k == N){
            res++;
            return;
        }

        for (int i = 0; i < 27; i++){
            if (alphabet[i]==0)continue;

            if (pre != i+'a'){
                alphabet[i]--;
                dfs(k +1, i+'a');
                alphabet[i]++;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        N = s.length();
        for (int i = 0; i < s.length(); i++)alphabet[s.charAt(i)-'a']++;

        dfs(0,0);
        System.out.println(res);
    }


}