import java.math.BigInteger;
import java.util.*;
import java.io.*;



public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String s = br.readLine();
            boolean check =false;
            int a= s.indexOf("A"), f= s.indexOf("F"),  c = s.indexOf("C")
                    , aLast= s.lastIndexOf("A"), fLast= s.lastIndexOf("F");
            if(s.charAt(s.length()-1)=='A' ||s.charAt(s.length()-1)=='F'||s.charAt(s.length()-1)=='C'){
                if(a<f && f<c){
                    if(aLast==f-1 && fLast==c-1) check=true;
                }
            }
            if(check) ans.append("Infected!");
            else ans.append("Good");
            ans.append("\n");
        }
        System.out.println(ans);
    }

}