import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, Pos> left = new HashMap<>(); // 한글 자음(왼손)
    static HashMap<String, Pos> right = new HashMap<>(); // 한글 모음(오른손)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        initKeyBoard();

        Pos lNow = left.get(st.nextToken());
        Pos rNow = right.get(st.nextToken());

        String[] cmd = br.readLine().split("");
        int total = cmd.length; // 각 키를 누르는 시간

        Queue<Pos> lQueue = new LinkedList<>();
        Queue<Pos> rQueue = new LinkedList<>();
        for (String s : cmd) {
            if (left.containsKey(s)) { // 해당 문자를 왼손으로 쳐야 하는 경우
                Pos next = left.get(s);
                total += Math.abs(lNow.x - next.x) + Math.abs(lNow.y - next.y); // 거리 계산
                lNow = next;
            } else { // 해당 문자를 오른손으로 쳐야 하는 경우
                Pos next = right.get(s);
                total += Math.abs(rNow.x - next.x) + Math.abs(rNow.y - next.y); // 거리 계산
                rNow = next;
            }
        }
        System.out.println(total);
    }

    public static void initKeyBoard() {
        left.put("q", new Pos(1, 1));
        left.put("w", new Pos(1, 2));
        left.put("e", new Pos(1, 3));
        left.put("r", new Pos(1, 4));
        left.put("t", new Pos(1, 5));
        left.put("a", new Pos(2, 1));
        left.put("s", new Pos(2, 2));
        left.put("d", new Pos(2, 3));
        left.put("f", new Pos(2, 4));
        left.put("g", new Pos(2, 5));
        left.put("z", new Pos(3, 1));
        left.put("x", new Pos(3, 2));
        left.put("c", new Pos(3, 3));
        left.put("v", new Pos(3, 4));

        right.put("y", new Pos(1, 6));
        right.put("u", new Pos(1,7));
        right.put("i", new Pos(1,8));
        right.put("o", new Pos(1,9));
        right.put("p", new Pos(1,10));
        right.put("h", new Pos(2,6));
        right.put("j", new Pos(2,7));
        right.put("k", new Pos(2,8));
        right.put("l", new Pos(2,9));
        right.put("b", new Pos(3,5));
        right.put("n", new Pos(3,6));
        right.put("m", new Pos(3,7));
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}