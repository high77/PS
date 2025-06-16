import java.io.*;

public class Main{
    static int[] alphabet = new int[27];
    static int res;
    static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        L = s.length();
        for (int i = 0; i < s.length(); i++)alphabet[s.charAt(i)-'a']++;

        dfs(0,' ');
        System.out.println(res);
    }

    public static void dfs(int index,char pre){
        if (index== L){
            res++;
            return;
        }

        for (int i = 0; i < 27; i++){
            if (alphabet[i]==0)continue;

            if (pre != (char) (i+'a')){
                alphabet[i]--;
                dfs(index+1, (char)(i+'a'));
                alphabet[i]++;
            }

        }
    }
}