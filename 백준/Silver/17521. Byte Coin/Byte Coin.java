import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int days;
        long money, coin = 0;
        int min = 51, max = 0;
        int now = 0;
        int[] price;

        StringTokenizer st = new StringTokenizer(br.readLine());

        days = Integer.parseInt(st.nextToken());
        money = Long.parseLong(st.nextToken());

        price = new int[days];

        for (int x = 0; x < days; x++) price[x] = Integer.parseInt(br.readLine());

        for (int x = 0; x < days-1; x++) {
            if (coin == 0 && price[x] < price[x + 1]) {
                coin = money / price[x];
                money -= coin * price[x];
            }

      
            if (price[x] > price[x + 1]) {
                money += coin * price[x];
                coin = 0;
            }
        }


        money += coin * price[days-1];
        System.out.println(money);
    }
}
