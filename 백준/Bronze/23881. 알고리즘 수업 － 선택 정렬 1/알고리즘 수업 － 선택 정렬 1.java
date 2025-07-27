import java.io.*;
import java.util.*; 
public class Main {	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken()), cnt=0;		
        int [] a = new int [n];		
        st = new StringTokenizer(br.readLine());	
        for(int i=0;i<n;i++)  a[i]=Integer.parseInt(st.nextToken());		
        for(int i=n-1;i>0;i--) {
            int m=0, idx=0;			
            for(int j=0;j<=i;j++) {			
                if(m<a[j]) {			
                    m=a[j];				
                    idx=j;			
                }		
            }		
            if(a[i]!=m) {	
                int t=a[i];		
                a[i]=a[idx];	
                a[idx]=t;			
                cnt++;				
                if(cnt==k) {		
                    System.out.println(Math.min(a[i], a[idx])+" "+Math.max(a[i], a[idx]));			
                    break;				
                }			
            }	
        }		
        if(cnt<k) System.out.println("-1");
    }
}

