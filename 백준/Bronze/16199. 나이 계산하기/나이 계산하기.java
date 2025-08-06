import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y1 = Integer.parseInt(st.nextToken()),m1 = Integer.parseInt(st.nextToken()),
        d1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int y2 = Integer.parseInt(st.nextToken());
		int m2 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());
		
		int age = y2 - y1;
		
		//연도가 같을 경우, 연도가 다를때 달이 같고 다른 경우 등 조건을 걸고 출력
		if(y1 == y2) {
			System.out.println(age);
		}else{
			if(m1 > m2) {
				System.out.println(age - 1);
			}else if(m1 == m2){
				if(d1 <= d2) {
					System.out.println(age);
				}else {
					System.out.println(age - 1);
				}
			}else{
				System.out.println(age);
			}
		}
		System.out.println(age + 1);
		System.out.println(age);
	}

}