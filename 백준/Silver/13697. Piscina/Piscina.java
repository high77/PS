import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            double dx = Double.parseDouble(st.nextToken());
            double dy = Double.parseDouble(st.nextToken());
            double dz = Double.parseDouble(st.nextToken());

            if (dx == 0 && dy == 0 && dz == 0) break;

            st = new StringTokenizer(br.readLine());
            int pStock = Integer.parseInt(st.nextToken());
            int mStock = Integer.parseInt(st.nextToken());
            int gStock = Integer.parseInt(st.nextToken());

            // 5cm 단위 정수화 (부동소수점 오차 방지 +5)
            int x = (int) (dx * 100 + 0.5) / 5;
            int y = (int) (dy * 100 + 0.5) / 5;
            int z = (int) (dz * 100 + 0.5) / 5;

            // 5cm 배수가 아니면 불가 (이미 /5를 했으므로 원본이 5의 배수인지 체크)
            if (Math.round(dx * 100) % 5 != 0 || Math.round(dy * 100) % 5 != 0 || Math.round(dz * 100) % 5 != 0) {
                ans.append("impossivel\n");
                continue;
            }

            // 각 면의 Capacity 계산 (인라인 처리로 메모리 절약)
            int capL = (x/6)*(y/6) + 2*((x/6)*(z/6)) + 2*((y/6)*(z/6));
            int capM = (x/3)*(y/3) + 2*((x/3)*(z/3)) + 2*((y/3)*(z/3));
            long totalArea = (long)x*y + 2L*x*z + 2L*y*z;

            // Greedy 배분
            int usedG = Math.min(gStock, capL);
            int usedM = Math.min(mStock, capM - usedG * 4);
            long neededP = totalArea - (usedG * 36L + usedM * 9L);

            if (pStock >= neededP) {
                ans.append(neededP).append(" ").append(usedM).append(" ").append(usedG).append("\n");
            } else {
                ans.append("impossivel\n");
            }
        }
        System.out.print(ans);
    }
}