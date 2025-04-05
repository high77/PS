import java.io.*;
import java.util.*;

public class Main {
    static class Team{
        int level;
        ArrayList<String> names;
        public Team(int level, ArrayList<String> names){
            this.level = level;
            this.names = names;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken())
                , m = Integer.parseInt(st.nextToken());
        ArrayList<Team> teams = new ArrayList<>();
        HashMap<String,Integer> players = new HashMap<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            players.put(n,l);
            boolean flag = false;
            for (Team team : teams) {
                if (l>=team.level-10 && l<=team.level+10 && team.names.size()<m) {
                    team.names.add(n);
                    flag = true;
                    break;
                }
            }
            if (!flag) teams.add(new Team(l,new ArrayList<>(Arrays.asList(n))));


        }
        for (Team team : teams) {
            if (team.names.size()<m) ans.append("Waiting!\n");
            else ans.append("Started!\n");
            Collections.sort(team.names);
            for (String n : team.names) ans.append(players.get(n)+" "+n + "\n");
        }
        System.out.println(ans);
    }
}