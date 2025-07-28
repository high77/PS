import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S;
        while ((S=br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(S);
            int A = Integer.parseInt(st.nextToken())
                    , B = Integer.parseInt(st.nextToken())
                    , C = Integer.parseInt(st.nextToken());

            System.out.println(Math.max(B-A, C-B)-1);

        }

    }
}

