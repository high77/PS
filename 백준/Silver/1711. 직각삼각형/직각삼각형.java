import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long ans = 0;
        N = Integer.parseInt(br.readLine());
        list = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (check(list[i], list[j], list[k])) ans++;
                }
            }
        }

        System.out.println(ans);
    }

    static boolean check(int[] a,int[] b,int[] c){
        long l1 = (long) (a[0] - b[0]) *(a[0]-b[0]) + (long) (a[1] - b[1]) *(a[1]-b[1])
                , l2 = (long) (a[0] - c[0]) *(a[0]-c[0]) + (long) (a[1]-c[1])*(a[1]-c[1])
                , l3 = (long) (b[0]-c[0])*(b[0]-c[0])+ (long) (b[1]-c[1])*(b[1]-c[1]);
        if (l1+l2==l3 || l1==l2+l3 || l2==l3+l1) return true;
        return false;
    }


}