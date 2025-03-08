import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while(true) {
            i++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            double A = Double.parseDouble(st.nextToken()),
                    B = Double.parseDouble(st.nextToken()),
                    C = Double.parseDouble(st.nextToken());
            if(B == 0) break;
            C /= 3600;
            double distance = ((((A * 3.1415927) * B) / 12) / 5280);
            double MPH = (distance / C);

            ans.append("Trip #" + i + ": "+String.format("%.2f", distance) + " "+String.format("%.2f", MPH)+"\n");
        }
        System.out.println(ans);

    }
}
