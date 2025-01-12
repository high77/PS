import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 입력 데이터 분리
        String[] dateTimeParts = input.split(" ");
        String month = dateTimeParts[0];
        int day = Integer.parseInt(dateTimeParts[1].replace(",", ""));
        int year = Integer.parseInt(dateTimeParts[2]);
        String[] timeParts = dateTimeParts[3].split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);

        // 월 문자열을 숫자로 변환
        int monthNumber = convertMonthToNumber(month);

        // 입력 시간 설정
        int totalDaysInYear = isLeapYear(year) ? 366 : 365;
        int[] daysInMonths = isLeapYear(year)
                ? new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
                : new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int daysElapsed = 0;
        for (int i = 1; i < monthNumber; i++) {
            daysElapsed += daysInMonths[i];
        }
        daysElapsed += day - 1;

        long totalMinutesElapsed = (daysElapsed * 24L * 60L) + (hour * 60L) + minute;
        long totalMinutesInYear = totalDaysInYear * 24L * 60L;

        // 진행률 계산
        double progressPercentage = (double) totalMinutesElapsed / totalMinutesInYear * 100;

        // 결과 출력
        System.out.println(progressPercentage);
    }

    // 월을 숫자로 변환하는 메서드
    private static int convertMonthToNumber(String month) {
        switch (month) {
            case "January": return 1;
            case "February": return 2;
            case "March": return 3;
            case "April": return 4;
            case "May": return 5;
            case "June": return 6;
            case "July": return 7;
            case "August": return 8;
            case "September": return 9;
            case "October": return 10;
            case "November": return 11;
            case "December": return 12;
            default: throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    // 윤년 확인 메서드
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
