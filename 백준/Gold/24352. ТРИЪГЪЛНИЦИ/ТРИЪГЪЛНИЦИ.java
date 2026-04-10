import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] R = new int[N], G = new int[N], B = new int[N];
        int rSize = 0, gSize = 0, bSize = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String color = st.nextToken();
            int len = Integer.parseInt(st.nextToken());
            
            if (color.equals("r")) R[rSize++] = len;
            else if (color.equals("g")) G[gSize++] = len;
            else B[bSize++] = len;
        }

        Arrays.sort(R, 0, rSize);
        Arrays.sort(G, 0, gSize);
        Arrays.sort(B, 0, bSize);

        long ans = 0;

        for (int i = 0; i < rSize; i++) {
            for (int j = 0; j < gSize; j++) {
                int minV = Math.abs(R[i] - G[j]) + 1, maxV = R[i] + G[j];
                ans += lowerBound(B, bSize, maxV) - lowerBound(B, bSize, minV);
            }
        }

        System.out.println(ans);
    }

    // 배열 내에서 key값 이상인 첫 번째 원소의 인덱스를 반환
    static int lowerBound(int[] arr, int size, int key) {
        int low = 0, high = size;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] >= key) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}