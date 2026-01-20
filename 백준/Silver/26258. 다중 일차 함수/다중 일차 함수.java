import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            double k = Double.parseDouble(br.readLine());
            int s=0,e=N-1;
            while (s<e){
                int mid = (s+e)/2;
                if (nodes[mid].x<k) s=mid+1;
                else e = mid;
            }
            int tmp =nodes[e].y- nodes[e-1].y;
            if (tmp>0) ans.append("1");
            else if (tmp==0) ans.append("0");
            else ans.append("-1");
            ans.append("\n");
        }

        System.out.println(ans);
    }
}