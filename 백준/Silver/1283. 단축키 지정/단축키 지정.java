import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static boolean f(String[] words, HashSet<Character> set, StringBuilder ans){
        for (int i = 0; i < words.length; i++) {
            char c =  Character.toLowerCase(words[i].charAt(0));
            if (set.contains(c)) continue;
            set.add(c);
            for (int k=0;k<i;k++) ans.append(words[k]+" ");
            ans.append("["+words[i].charAt(0)+"]"+words[i].substring(1));
            for (int k=i+1;k<words.length;k++) ans.append(" "+words[k]);
            ans.append("\n");
            return true;
        }
        return false;
    }

    static boolean f2(String[] words, HashSet<Character> set, StringBuilder ans){
        for (int i = 0; i < words.length; i++) {
            for (int j=0;j<words[i].length();j++) {
                char c = Character.toLowerCase(words[i].charAt(j));
                if (set.contains(c)) continue;
                set.add(c);
                for (int k=0;k<i;k++) ans.append(words[k]+" ");
                ans.append(words[i].substring(0,j)+"["+words[i].charAt(j)+"]"+words[i].substring(j+1));
                for (int k=i+1;k<words.length;k++) ans.append(" "+words[k]);
                ans.append("\n");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashSet<Character> set = new HashSet<>();
        for (int i=0;i<N;i++) {
            String[] words = br.readLine().split(" ");
            if (f(words, set, ans)) continue;
            if (f2(words, set, ans)) continue;
            for (int j = 0; j < words.length; j++) {
                ans.append(words[j]);
                if (j !=words.length-1) ans.append(" ");
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }

}