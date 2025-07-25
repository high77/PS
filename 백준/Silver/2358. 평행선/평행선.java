import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), ans = 0;
        HashMap<Integer,Integer> xMap = new HashMap<>(), yMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            if (xMap.containsKey(x)) xMap.put(x,xMap.get(x)+1);
            else xMap.put(x,1);
            if (yMap.containsKey(y)) yMap.put(y,yMap.get(y)+1);
            else yMap.put(y,1);
        }
        for (int x: xMap.keySet()) {
            if (xMap.get(x)>1) ans ++;
        }
        for (int y: yMap.keySet()) {
            if (yMap.get(y)>1) ans ++;
        }
        System.out.println(ans);

    }
}