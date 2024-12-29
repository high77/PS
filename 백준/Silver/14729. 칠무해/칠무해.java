import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        double[] list = new double[N];
        for (int i = 0; i < N; i++) list[i] = Double.parseDouble(br.readLine());
        Arrays.sort(list);
        for (int i = 0; i < 7; i++) ans.append(String.format("%.3f",list[i])+"\n");
        System.out.println(ans);
    }

}
