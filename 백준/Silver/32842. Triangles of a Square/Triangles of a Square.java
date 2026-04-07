import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int corners = 0;

        if ((x1 == 0 || x1 == 2024) && (y1 == 0 || y1 == 2024)) corners++;
        if ((x2 == 0 || x2 == 2024) && (y2 == 0 || y2 == 2024)) corners++;

        System.out.println(2 - corners);
    }
}