import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        char[] plain = br.readLine().toCharArray()
                , key = br.readLine().toCharArray();
        int i =0,l=key.length;
        for (char c : plain) {
            int tmp = (c-key[i]+'a'-1);
            if (c==' ') ans.append(c);
            else ans.append((char) (tmp<'a'?tmp+26:tmp));
            i=(i+1)%l;
        }
        System.out.println(ans);
    }

}
