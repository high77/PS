import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;

public class Main {
    static int checkYear(int y){
        if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) return 1;
        else return 0;
    }
    static int calcDay(int y, int m, int d){
        int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int days = 0;

        for(int i = 1; i < y; i++){
            days += 365 + checkYear(i);
        }

        for(int i = 1; i < m; i++){
            if(i == 2) days += checkYear(y);
            days += day[i];
        }

        days += d;

        return days;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int year1 = Integer.parseInt(st.nextToken())
                , month1 = Integer.parseInt(st.nextToken())
                , day1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int year2 = Integer.parseInt(st.nextToken())
                , month2= Integer.parseInt(st.nextToken())
                , day2 = Integer.parseInt(st.nextToken());

        int dDay = calcDay(year2, month2, day2)
                , now = calcDay(year1, month1, day1);
        if (year2 - year1 > 1000 || year2 - year1 == 1000 && (month1 < month2 || month1 == month2 && day1 <= day2)) ans.append("gg");
        else ans.append("D-"+(dDay-now));
        System.out.println(ans);

    }
}
