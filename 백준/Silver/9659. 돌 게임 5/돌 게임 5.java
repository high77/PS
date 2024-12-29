import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        char[] input = br.readLine().toCharArray();
        boolean flag = (input[input.length - 1]-48)%2==0?false:true;
        System.out.println(flag?"SK":"CY");
    }

}