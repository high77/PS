import java.io.*;
import java.util.*;

public class Main {

    static String answer; // 결과 값
    static int[] stock = new int[14];
    static int jc, sc; // 성민이와 준현이의 현금 값
    static int numJ = 0, numS = 0; // 성민이와 준현이의 주식 수

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        jc = cash; // 초기화
        sc = cash;


        for (int i = 0; i < 14; i++) {
            stock[i] = Integer.parseInt(st.nextToken()); // 현재 주가

            if (jc != 0 && jc / stock[i] > 0) { // 만약 준현이가 주식을 살 수 있다면
                numJ += jc / stock[i];
                jc = jc % stock[i];
            }

            if (i > 2) {
                sTrading(stock[i], i);
            }
        }

        jc += numJ * stock[13];
        sc += numS * stock[13];


        if (jc > sc) {
            System.out.println("BNP");
        } else if (jc == sc) {
            System.out.println("SAMESAME");
        } else {
            System.out.println("TIMING");
        }
    }

    public static void sTrading(int money, int cnt) {
        int num3 = stock[cnt - 3], num2 = stock[cnt - 2], num1 = stock[cnt - 1]; 

        if (numS != 0 && num1 < money && num2 < num1 && num3 < num2) {
            sc += money * numS;
            numS = 0; 

        } else if (sc != 0 && sc / money > 0 && num1 > money && num2 > num1 && num3 > num2) {
            numS += sc / money;
            sc = sc % money;
        }

    }
}