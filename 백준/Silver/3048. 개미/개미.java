import java.io.*;
import java.util.*;

public class Main {
    static class Ant {
        char name;
        int dir;
        Ant (char name, int dir) {
            this.name = name;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken()),N2 = Integer.parseInt(st.nextToken());
        String A = br.readLine(),B = br.readLine();
        int T = Integer.parseInt(br.readLine());

        Ant[] ants = new Ant[N1+N2];

        for (int i = 0; i < N1; i++) ants[i] =new Ant (A.charAt(N1-1-i),1);

        for (int i = 0; i < N2; i++) ants[N1+i] = new Ant(B.charAt(i),-1);

        for (int t=0; t<T; t++) {
            for (int i = 0; i < ants.length-1; i++) {
                if (ants[i].dir == 1 && ants[i+1].dir == -1) {
                    Ant tmp = ants[i];
                    ants[i] = ants[i+1];
                    ants[i+1] = tmp;
                    i++;
                }
            }
        }

        for (Ant ant:ants) ans.append(ant.name);
        System.out.println(ans);
    }
}