import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // 왼쪽: 공격력 , 오른쪽: 생명력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aAttack = Integer.parseInt(st.nextToken());
        int aLife = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int bAttack = Integer.parseInt(st.nextToken());
        int bLife = Integer.parseInt(st.nextToken());

        String answer = "";

        while (true){
            if (aLife == 0 || bLife == 0){
                break;
            }else{
                aLife -= bAttack;
                bLife -= aAttack;

                if (aLife <= 0 && bLife <= 0){
                    answer = "DRAW";
                    break;
                }else if (aLife <= 0){
                    answer = "PLAYER B";
                    break;
                }else if (bLife <= 0 ){
                    answer = "PLAYER A";
                    break;
                }
            }
        }

        sb.append(answer);
        System.out.println(sb);
    }
}
