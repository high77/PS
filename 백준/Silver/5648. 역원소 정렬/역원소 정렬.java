import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		long[] list = new long[N];
		int idx = 0;

		while (true) {
			if (st.hasMoreTokens()) {
				StringBuilder input = new StringBuilder(st.nextToken());
				list[idx++] = Long.parseLong(input.reverse().toString());
				if (idx == N) break;
			} else st = new StringTokenizer(br.readLine());
		}

		Arrays.sort(list);

		for (long n : list) ans.append(n).append("\n");
		
		System.out.println(ans);
	}
}