import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    static int K = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        quickSort(A, 0, N-1);

        if (K>0) System.out.print("-1");
    }

    public static void quickSort(int[] A, int s, int e) {
        if (s < e) {
            int pivot = partition(A, s, e);
            quickSort(A, s, pivot-1);
            quickSort(A, pivot+1, e);
        }
    }

    public static int partition(int[] A, int s, int e) {
        int pivot = A[e];
        int idx = s -1;

        for (int i = s; i < e; i++) {
            if (A[i] <= pivot) {
                idx++;
                swap(A, idx, i);
            }
        }

        if (idx+1 != e) swap(A, idx+1, e);

        return idx+1;
    }

    public static void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;

        K--;
        if (K==0) System.out.print(A[a] + " " + A[b]);
    }
}