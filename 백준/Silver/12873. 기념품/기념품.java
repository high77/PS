import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        ArrayList<Integer>list=new ArrayList<>();

        for(int i=1;i<=N;i++) list.add(i);

        int stage=1, index=0;

        while(list.size()>1) {

            long delete=(long)Math.pow(stage,3);
            index=(int)((index+delete-1)%list.size());

            list.remove(index);
            stage++;
        }
        System.out.println(list.get(0));
    }

}