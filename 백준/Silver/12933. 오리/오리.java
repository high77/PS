import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] list = new int[6];
        int size = s.length();
        int max = 0;
        list[0] = size;

        for(int i = 0; i < size; i++) {
            int n = 0;
            if(s.charAt(i) == 'q') n = 1;
            if(s.charAt(i) == 'u') n = 2;
            if(s.charAt(i) == 'a') n = 3;
            if(s.charAt(i) == 'c') n = 4;
            if(s.charAt(i) == 'k') n = 5;
            if(list[n-1] == 0) {
                System.out.println("-1");
                return;
            }
            list[n]++;
            list[n-1]--;
            max = Math.max(max, list[1]+list[2]+list[3]+list[4]);
        }

        if(list[5] * 5 != size) {
            System.out.println("-1");
            return;
        }
        System.out.println(max);
    }
}