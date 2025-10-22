import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int count = 0;
            String[] sArr = br.readLine().split(" ");

            if(sArr.length == 1)
                break;

            int[] arr = new int[sArr.length - 1];
            for(int i=0; i<arr.length; i++)
                arr[i] = Integer.parseInt(sArr[i]);

            Arrays.sort(arr);

            for(int i=0; i<arr.length-1; i++) {
                for(int j=i+1; j<arr.length; j++) {
                    if((arr[i]*2) == arr[j]) {
                        count ++;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}