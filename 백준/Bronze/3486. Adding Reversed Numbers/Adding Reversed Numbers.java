import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static String getResultWithoutUnnecessaryZeros(String result) {
        int firstNonZeroIdx = result.length();
        
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                firstNonZeroIdx = i;
                break;
            }
        }
        
        if (firstNonZeroIdx == result.length()) {
            return "0";
        }
        
        return result.substring(firstNonZeroIdx);
    }

    public static void printReverseSum(String a, String b) {
        StringBuilder revA = new StringBuilder(a).reverse();
        StringBuilder revB = new StringBuilder(b).reverse();
        
        int sum = Integer.parseInt(revA.toString()) + Integer.parseInt(revB.toString());
        StringBuilder sumStr = new StringBuilder(String.valueOf(sum)).reverse();
        
        System.out.println(getResultWithoutUnnecessaryZeros(sumStr.toString()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        for (int n = 0; n < N; n++) {
            String a = scanner.next();
            String b = scanner.next();
            printReverseSum(a, b);
        }
        
        scanner.close();
    }
}
