package Core;
import java.util;

public class Team {
    String m_countryName;
    Sports.Sport m_sport;
    int m_wins;
    int m_draws;
    int m_losses;
    Deque<String> m_players;
    Deque<Match> m_matches;
    
    private Team() {}
    
    public Team(String countryName, Sports.Sport sport, Deque<String> players) {
        this.m_countryName = countryName;
        this.m_sport = sport;
        this.m_wins = 0;
        this.m_draws = 0;
        this.m_losses = 0;
        this.players = new Deque<String>(players);
        this.m_matches = new Deque<String>();
    }

    //metodo match
    public void match(Team t2, int scoret1, int scoret2){
        Match m = new Match(this, t2, score1, score2, this.sport);
        this.matches.addFirst(m);
    }
    
    public String countryName() { return this.m_countryName; }
    
    public void printMatchRecord(String path) {
        PrintWriter writer = new PrintWriter(new FileWriter(path, true), "UTF-8");
        String stats = String.format("%-12s", this.m_countryName);
        stats += String.format("%-12d", this.m_wins);
        stats += String.format("%-12d", this.m_draws);
        stats += String.format("%-12d", this.m_losses);
        writer.println(stats);
    }
    
    public void printTeamStatistics(String path) {
        
        // Print header
        PrintWriter writer = new PrintWriter(new FileWriter(path, true), "UTF-8");
        writer.println(this.m_countryName + " - " + this.m_sport.getName());
        
        // Print player names
        Iterator it = m_players.iterator();
        while (!it.hasNext()) {
            String name = it.next();
            writer.println(name);
        }
        
        // Print matches
        writer.println(String.format("%-12s", "Adversários") + "Placar");
        it = m_matches.iterator();
        while (!it.hasNext()) {
            Match m = it.next();
            m.printStatistics(path, this);
        }
    }
    
    protected Sport getSport() { return this.m_sport; }
}