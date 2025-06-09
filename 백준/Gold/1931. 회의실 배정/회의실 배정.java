import java.io.*;
import java.util.*;

public class Main {
    static class Time implements Comparable<Time> {
        int s,e;
        public Time(int s, int e) {
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Time o){
            if(this.e != o.e) return o.e - this.e;
            else return o.s-this.s;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine()),res=1;
        ArrayList<Time> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())
                    , b = Integer.parseInt(st.nextToken());
            list.add(new Time(a, b));
        }
        Collections.sort(list);
        int y= list.get(list.size()-1).e;
        for (int i= list.size()-2; i >= 0; i--){
            if (list.get(i).s>=y){
                res++;
                y = list.get(i).e;
            }
        }

        System.out.println(res);
    }
}