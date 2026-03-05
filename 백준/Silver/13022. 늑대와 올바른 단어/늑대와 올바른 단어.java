import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        int i = 0;

        while (i < len) {
            int n = 0;
            if (s.charAt(i) != 'w') { System.out.println(0); return; }
            while (i < len && s.charAt(i) == 'w') {
                n++;
                i++;
            }

            char[] wolf = {'o', 'l', 'f'};
            for (char target : wolf) {
                int count = 0;
                while (i < len && s.charAt(i) == target) {
                    count++;
                    i++;
                }
                if (count != n) {
                    System.out.println(0);
                    return;
                }
            }
        }

        System.out.println(1);
    }
}