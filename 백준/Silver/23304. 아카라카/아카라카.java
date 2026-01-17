import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (isAkaraka(s)) System.out.println("AKARAKA");
        else System.out.println("IPSELENTI");
    }

    static boolean isAkaraka(String s) {
        int len = s.length();

        if (len == 1) return true;
        if (!isPalindrome(s)) return false;
        int half = len / 2;
        String prefix = s.substring(0, half);
        return isAkaraka(prefix);
    }

    static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}