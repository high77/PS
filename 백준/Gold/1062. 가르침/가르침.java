import java.io.*;
import java.util.*;

public class Main {
    static int N,K,res;
    static int[] list;
    static char[] charList ;
    static HashSet<Integer>[] arr = new HashSet[26];

    static void f(int k,int i){
        int tmp=0;
        for (int n=0;n<N;n++){
            if (list[n]==0) tmp++;
        }
        res = Math.max(res,tmp);

        if (k==K) return;
        if (i==charList.length) return;

        f(k,i+1);
        for (int n:arr[charList[i]-'a']) list[n]--;
        f(k+1,i+1);
        for (int n:arr[charList[i]-'a']) list[n]++;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        res = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N];
        if (K==26) ans.append(N);
        else if (K<5) ans.append(0);
        else {
            K-=5;
            for (int i = 0; i < 26; i++) arr[i] = new HashSet<>();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                String S = br.readLine();
                HashSet<Character> tmp = new HashSet<>();
                for (char c : S.toCharArray()) {
                    if (c=='a' || c=='n' || c=='t' || c=='i' || c=='c') continue;
                    set.add(c);
                    tmp.add(c);
                    arr[c-'a'].add(i);
                }
                list[i] = tmp.size();
            }
            charList = new char[set.size()];
            int i = 0;
            for (char c : set) charList[i++] = c;
            f(0,0);
            ans.append(res);
        }
        System.out.println(ans);
    }
}
