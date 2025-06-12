import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int findClockNum(String s) {
        int min = Integer.parseInt(s);

        Queue<String> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) q.add(String.valueOf(s.charAt(i)));


        for (int j = 1; j < q.size(); j++) {
            q.add(q.remove());
            int now = Integer.parseInt(q.stream().collect(Collectors.joining("")));
            min = min > now ? now : min;
        }
        return min;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = "";
        for (int i = 0; i < 4; i++) N += st.nextToken();

        int inputNum = findClockNum(N), cnt = 1;

        for (int k = 1111; k <= inputNum; k++) {
            if (k == inputNum) {
                System.out.println(cnt);
                break;
            }

            if (!String.valueOf(k).contains("0") && findClockNum(String.valueOf(k)) == k) cnt++;
        }
    }


}