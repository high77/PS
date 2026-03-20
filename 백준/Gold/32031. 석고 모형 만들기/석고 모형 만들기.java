import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 정점 개수: (R+1) * (C+1) * 2 (층)
        int numVertices = (R + 1) * (C + 1) * 2;
        parent = new int[numVertices];
        for (int i = 0; i < numVertices; i++) parent[i] = i;

        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                char type = line.charAt(c);
                addEdges(r, c, type, C);
            }
        }

        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            if (parent[i] == i) count++;
        }
        System.out.println(count);
    }

    private static int getIdx(int r, int c, int z, int C) {
        return (r * (C + 1) + c) * 2 + z;
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) parent[rootA] = rootB;
    }

    private static int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    private static void addEdges(int r, int c, char type, int C) {
        // 단위 셀의 8개 정점 인덱스 추출
        int v000 = getIdx(r, c, 0, C);
        int v001 = getIdx(r, c, 1, C);
        int v100 = getIdx(r + 1, c, 0, C);
        int v101 = getIdx(r + 1, c, 1, C);
        int v010 = getIdx(r, c + 1, 0, C);
        int v011 = getIdx(r, c + 1, 1, C);
        int v110 = getIdx(r + 1, c + 1, 0, C);
        int v111 = getIdx(r + 1, c + 1, 1, C);

        if (type == 'O') { // 수직: 위-아래 연결
            union(v000, v001);
            union(v100, v101);
            union(v010, v011);
            union(v110, v111);
        } else if (type == 'I') { // 세로(R축): 앞-뒤 연결
            union(v000, v100);
            union(v010, v110);
            union(v001, v101);
            union(v011, v111);
        } else if (type == 'H') { // 가로(C축): 좌-우 연결
            union(v000, v010);
            union(v100, v110);
            union(v001, v011);
            union(v101, v111);
        }
    }
}
