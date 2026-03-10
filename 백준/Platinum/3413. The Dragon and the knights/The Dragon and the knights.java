import java.io.*;
import java.util.*;

public class Main {
    // 기사의 영역 위치를 나타낼 클래스 (100개의 부호를 비트로 저장)
    static class Signature {
        long low, high; // n이 최대 100이므로 64비트 변수 2개로 충분

        Signature(long low, long high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Signature that = (Signature) o;
            return low == that.low && high == that.high;
        }

        @Override
        public int hashCode() {
            return Objects.hash(low, high);
        }
    }

    static class Line {
        long a, b, c;
        Line(long a, long b, long c) {
            this.a = a; this.b = b; this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Line[] lines = new Line[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                lines[i] = new Line(Long.parseLong(st.nextToken()),
                        Long.parseLong(st.nextToken()),
                        Long.parseLong(st.nextToken()));
            }

            // 1. 전체 영역의 수 계산: R = 1 + n + 교점수
            long intersections = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    // 평행 판정: A1*B2 - A2*B1 != 0 이면 교점 발생
                    if (lines[i].a * lines[j].b != lines[j].a * lines[i].b) {
                        intersections++;
                    }
                }
            }
            long totalRegions = 1 + n + intersections;

            // 2. 기사들의 영역 체크
            HashSet<Signature> occupiedRegions = new HashSet<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());

                long low = 0, high = 0;
                for (int j = 0; j < n; j++) {
                    // 식의 결과가 양수인지 음수인지 판단하여 비트 설정
                    if (lines[j].a * x + lines[j].b * y + lines[j].c > 0) {
                        if (j < 64) low |= (1L << j);
                        else high |= (1L << (j - 64));
                    }
                }
                occupiedRegions.add(new Signature(low, high));
            }

            // 3. 결과 판정
            if (occupiedRegions.size() == totalRegions) {
                sb.append("PROTECTED\n");
            } else {
                sb.append("VULNERABLE\n");
            }
        }
        System.out.print(sb);
    }
}