import java.io.*;
import java.util.*;

public class Main {

    static int C,N,T,L;
    static String S;

    static final String pass = "May Pass.";
    static final String timeout = "TLE!";
    static final int cpu_clock = 100000000;

    static boolean result;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());

            S = st.nextToken();
            N = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            checkTimeComplexcity();
        }

        System.out.print(ans);
    }

    private static void checkTimeComplexcity() {
        long caseTime = (long) L * cpu_clock / T;
        result = true;
        long temp;

        switch (S) {
            case "O(N)":
                result = caseTime >= N;
                break;

            case "O(N^2)":
                result = caseTime >= (long) N * N;
                break;

            case "O(N^3)":
                result = caseTime >= (long) N * N * N;
                break;

            case "O(2^N)":
                temp = 1;
                for (int i = 0; i < N; i++) {
                    temp <<= 1;
                    if (temp > caseTime) {
                        result = false;
                        break;
                    }
                }
                break;

            case "O(N!)":
                temp = 1;
                for (int i = 2; i <= N; i++) {
                    temp *= i;
                    if (temp > caseTime) {
                        result = false;
                        break;
                    }
                }
                break;
        }

        if (result) ans.append(pass);
        else ans.append(timeout);
        ans.append('\n');
       
    }
}
