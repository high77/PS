import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String binary = br.readLine();
        HashMap<String,Character> map = new HashMap<>();
        map.put("000",'0');map.put("001",'1');map.put("010",'2');
        map.put("011",'3');map.put("100",'4');map.put("101",'5');
        map.put("110",'6');map.put("111",'7');
        if (binary.length()%3 == 1)binary= "00"+binary;
        else if (binary.length()%3 == 2) binary= "0"+binary;
        for (int i = 0; i<binary.length() ; i+=3) ans.append(map.get(binary.substring(i,i+3)));
        System.out.println(ans);

    }
}
