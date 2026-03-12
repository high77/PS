import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        // 예외 케이스 처리
        if (n == 2 || n == 3 || n == 5) {
            System.out.println("impossible");
            return;
        }
        if (n == 1) {
            System.out.println("1 1 1\nA 0 0 U");
            return;
        }

        // 수학적 치환 공식을 통한 타일 사이즈 계산
        // 짝수일 때는 A=1, 홀수일 때는 A=2로 고정하고 B의 크기를 구합니다.
        long sizeA = (n % 2 == 0) ? 1 : 2;
        long sizeB = (n % 2 == 0) ? (n / 2) - 1 : (n - 5) / 2;
        long totalSize = (n % 2 == 0) ? (n / 2) : (n - 3);

        // 빠른 출력을 위한 버퍼
        StringBuilder sb = new StringBuilder();
        sb.append(sizeA).append(" ").append(sizeB).append(" ").append(totalSize).append("\n");

        // 상단 B 영역이 시작되는 Y 좌표 (커팅 라인) 계산
        long cutoffY = totalSize - (sizeB * sizeA);

        // 영역별로 타일 그리기 (메서드 분리)
        fillBottomTrapezoid(sb, sizeA, totalSize, cutoffY);
        fillTopTriangle(sb, sizeB, sizeA, cutoffY);

        // 모아둔 결과 한 번에 출력
        System.out.print(sb.toString());
    }

    private static void fillBottomTrapezoid(StringBuilder sb, long tileSize, long totalSize, long cutoffY) {
        for (long y = 0; y < cutoffY; y += tileSize) {
            for (long x = 0; x + y + tileSize <= totalSize; x += tileSize) {
                // 정방향 (U) 타일
                sb.append("A ").append(x).append(" ").append(y).append(" U\n");

                // 역방향 (D) 타일이 들어갈 자리가 있다면 추가 (Y좌표 보정 주의)
                if (x + y + 2 * tileSize <= totalSize) {
                    sb.append("A ").append(x).append(" ").append(y + tileSize).append(" D\n");
                }
            }
        }
    }

    private static void fillTopTriangle(StringBuilder sb, long tileSize, long rows, long startY) {
        for (long row = 0; row < rows; row++) {
            long yGlobal = startY + row * tileSize;
            long tilesInRow = rows - row; // 해당 층에 들어갈 정방향 타일의 개수

            for (long col = 0; col < tilesInRow; col++) {
                long xGlobal = col * tileSize;

                // 정방향 (U) 타일
                sb.append("B ").append(xGlobal).append(" ").append(yGlobal).append(" U\n");

                // 역방향 (D) 타일 추가
                if (col < tilesInRow - 1) {
                    sb.append("B ").append(xGlobal).append(" ").append(yGlobal + tileSize).append(" D\n");
                }
            }
        }
    }
}