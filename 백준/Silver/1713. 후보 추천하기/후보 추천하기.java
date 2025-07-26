import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<int[]> list = new LinkedList<>();
        boolean[] check = new boolean[101];
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (check[n]) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j)[0] == n ) {
                        list.get(j)[1]++;
                        break;
                    }
                }
            }else {
                check[n] = true;
                if (list.size()==N) {
                    int tmpN=0,tmpJ=0, min =Integer.MAX_VALUE;
                    for (int j = 0; j < N; j++) {
                        if (list.get(j)[1] < min) {
                            min =list.get(j)[1];
                            tmpN=list.get(j)[0];
                            tmpJ=j;
                        }
                    }
                    list.remove(tmpJ);
                    check[tmpN]= false;
                }
                list.addLast(new int[]{n,1});
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i)[0];
        Arrays.sort(res);
        for (int i = 0; i < list.size(); i++) ans.append(res[i]).append(" ");

        System.out.println(ans);

    }
}