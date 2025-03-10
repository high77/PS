import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int min=Integer.MAX_VALUE,res1=0,res2=0;
        int N = Integer.parseInt(br.readLine());
        String[][] list = new String[N+1][5];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 5; j++) list[i][j] = br.readLine();
        }
        for (int a = 1; a < N; a++) {
            for (int b = a+1; b <= N; b++) {
                int cnt =0;
                for (int i =0; i<5; i++) {
                    for (int j =0; j<7; j++) {
                        if (list[a][i].charAt(j)!=list[b][i].charAt(j)) cnt++;
                    }
                }
                if (min>cnt) {
                    min=cnt;
                    res1=a;
                    res2=b;
                }
            }
        }
        ans.append(res1+" "+res2);
        System.out.println(ans);

    }
}
