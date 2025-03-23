import java.io.*;
import java.util.*;

public class Main {

    static boolean check(char[][] arr, char player) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == player && arr[i][j+1] == player && arr[i][j+2] == player ) return true;
                if (arr[j][i] == player && arr[j+1][i] == player && arr[j+2][i] == player ) return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == player && arr[i+1][j+1] == player && arr[i+2][j+2] == player ) return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 2; j < 5; j++) {
                if (arr[i][j] == player && arr[i+1][j-1] == player && arr[i+2][j-2] == player ) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[][] arr = new char[5][5];
            for (int i = 0; i < 5; i++) arr[i] = br.readLine().toCharArray();
            boolean A  = check(arr, 'A'), B  = check(arr, 'B');
            if (A && B || !A&&!B) ans.append("draw");
            else if (A) ans.append("A wins");
            else ans.append("B wins");
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
