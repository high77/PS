import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] A, land, deadNutrients;
    static List<Tree> trees;

    static class Tree {
        int x, y, age;

        Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    static void springAndSummer() {
        deadNutrients = new int[N][N];
        List<Tree> aliveTrees = new ArrayList<>();

        for (Tree t : trees) {
            if (land[t.x][t.y] >= t.age) {
                land[t.x][t.y] -= t.age;
                aliveTrees.add(new Tree(t.x, t.y, t.age + 1));
            } else {
                deadNutrients[t.x][t.y] += t.age / 2;
            }
        }

        trees = aliveTrees; // 살아남은 트리들만 유지
    }

    static void fall() {
        List<Tree> newTrees = new ArrayList<>();

        for (Tree t : trees) {
            if (t.age % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                    int x = t.x + dx[d], y = t.y + dy[d];
                    if (x < 0 || y < 0 || x >= N || y >= N) continue;
                    newTrees.add(new Tree(x, y, 1));
                }
            }
        }

        trees.addAll(0, newTrees); // 새로 자란 트리를 앞에 추가
    }

    static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                land[i][j] += A[i][j] + deadNutrients[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        land = new int[N][N];
        trees = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                land[i][j] = 5; // 초기 양분 설정
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, age));
        }

        // 초기 정렬
        trees.sort(Comparator.comparingInt(t -> t.age));

        for (int year = 0; year < K; year++) {
            springAndSummer();
            fall();
            winter();
        }

        System.out.println(trees.size());
    }
}
