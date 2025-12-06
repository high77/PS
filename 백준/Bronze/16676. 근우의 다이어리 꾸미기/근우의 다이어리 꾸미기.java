import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int tmp = n, digit = 0;
        while(true){
            if(n <= 0) break;
            n /= 10;
            digit++;
        }
        int a = 1;
        for(int i = 1; i < digit; i++)a = a * 10 + 1;
        if(digit == 0)
            System.out.println(1);
        else if(a > tmp)
            System.out.println(digit-1);
        else
            System.out.println(digit);
    }
}
