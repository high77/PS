import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];
        for(int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();

        char[][] result = new char[N][N];
        for(int i = 0; i < N; i++) result[i] = br.readLine().toCharArray();

        boolean isExplode = false;

        int[] dy = {-1,-1,-1,0,0,1,1,1};
        int[] dx = {-1,0,1,-1,1,-1,0,1};

        int y, x;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(result[i][j] == 'x') {
                    int cnt = 0;
                    for(int k = 0; k < 8; k++) {
                        y = i + dy[k];
                        x = j + dx[k];
                        if(isIn(y,x) && board[y][x] == '*') cnt++;
                    }
                    result[i][j] = (char) (cnt + '0');
                    if(board[i][j] == '*') isExplode = true;
                }
            }
        }

        if(isExplode) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(board[i][j] == '*') result[i][j] = '*';
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) ans.append(result[i][j]);
            ans.append("\n");
        }
        System.out.println(ans);
    }

    public static boolean isIn(int y, int x){
        if(y < 0 || y >= N || x < 0 || x >= N) return false;
        return true;
    }


}