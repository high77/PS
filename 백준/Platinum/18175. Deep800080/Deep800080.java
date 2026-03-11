import java.io.*;
import java.util.*;

public class Main {
    static class Event implements Comparable<Event> {
        double pos;
        int type; // -1: 시작(START), 1: 끝(END)

        Event(double pos, int type) {
            this.pos = pos;
            this.type = type;
        }

        @Override
        public int compareTo(Event other) {
            if (this.pos != other.pos) {
                return Double.compare(this.pos, other.pos);
            }
            return Integer.compare(this.type, other.type);
        }
    }

    static class FastReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    String line = reader.readLine();
                    if (line == null) return null;
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) { return null; }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader(System.in);
        String sN = fr.next();
        if (sN == null) return;

        int n = Integer.parseInt(sN);
        double r = fr.nextLong();
        double a = fr.nextLong();
        double b = fr.nextLong();

        double L = Math.sqrt(a * a + b * b);
        Event[] events = new Event[2 * n];
        int eventCount = 0;

        for (int i = 0; i < n; i++) {
            double x = fr.nextLong();
            double y = fr.nextLong();

            double u_boat = (x * a + y * b) / L;
            double v_boat = Math.abs(x * b - y * a) / L;

            if (v_boat <= r) {
                double halfWidth = Math.sqrt(Math.max(0, (r - v_boat) * (r + v_boat)));
                events[eventCount++] = new Event(u_boat - halfWidth, -1);
                events[eventCount++] = new Event(u_boat + halfWidth, 1);
            }
        }

        Arrays.sort(events, 0, eventCount);

        int maxBoats = 0;
        int currentBoats = 0;
        for (int i = 0; i < eventCount; i++) {
            if (events[i].type == -1) {
                currentBoats++;
                if (currentBoats > maxBoats) maxBoats = currentBoats;
            } else {
                currentBoats--;
            }
        }

        System.out.println(maxBoats);
    }
}