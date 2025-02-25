import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('A',0);map.put('G',1);map.put('C',2);map.put('T',3);
        char[][] arr = {{'A','C','A','G'},{'C','G','T','A'},{'A','T','C','G'},{'G','A','G','T'}};
        char[] S = br.readLine().toCharArray();
        for (int i = N-2; i >=0; i--) S[i] = arr[map.get(S[i])][map.get(S[i+1])];
        System.out.println(S[0]);
    }
}
