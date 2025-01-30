import java.util.*;
import java.io.*;
public class Main {

    private static int getScore(char a, char b) {
        return (a == b) ? 1 : (a == 'R' && b == 'S' || a == 'S' && b == 'P' || a == 'P' && b == 'R') ? 2 : 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans  = new StringBuilder();
        int R = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        char[] list = st.nextToken().toCharArray();
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][R];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        }

        int score = 0;
        for(int j = 0; j<R; j++){
            for(int i = 0; i<N; i++){
                score += getScore(list[j], arr[i][j]);
            }
        }

        int res = 0;
        for(int j = 0; j<R; j++){
            int r = 0, s = 0, p = 0;
            for(int i = 0; i<N; i++){
                r += getScore('R', arr[i][j]);
                s += getScore('S', arr[i][j]);
                p += getScore('P', arr[i][j]);
            }
            res+= Math.max(r, Math.max(s, p));
        }
        ans.append(score+"\n"+res);
        System.out.println(ans);
    }

}

