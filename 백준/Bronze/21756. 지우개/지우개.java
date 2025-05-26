import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) list.add(i);
        
        while(list.size() >= 2) {
            for(int i = 0; i < list.size(); i++) {
                list.remove(i);
            }
        }

        System.out.println(list.get(0));
    }
}