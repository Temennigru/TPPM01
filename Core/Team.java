package Core;
import Sports.Sport;
import java.util.*;
import java.io.*;
import java.util.Vector;

public class Team {
    String m_countryName;
    Sports.Sport m_sport;
    int m_wins;
    int m_draws;
    int m_losses;
    Vector<String> m_players;
    Vector<Match> m_matches;
    
    private Team() {}
    
    public Team(String countryName, Sports.Sport sport, Deque<String> players) {
        this.m_countryName = countryName;
        this.m_sport = sport;
        this.m_wins = 0;
        this.m_draws = 0;
        this.m_losses = 0;
        this.m_players = new Vector<String>(players);
        this.m_matches = new Vector<Match>();
    }
    
    public Team(String countryName, Sports.Sport sport) {
        this.m_countryName = countryName;
        this.m_sport = sport;
        this.m_wins = 0;
        this.m_draws = 0;
        this.m_losses = 0;
        this.m_players = new Vector<String>();
        this.m_matches = new Vector<Match>();
    }

    //metodo match
    public void match(Team t2, int scoret1, int scoret2, int id){
        Match m = new Match(this, t2, scoret1, scoret2, id, this.m_sport);
        this.m_matches.add(m);
        t2.match(m);

        Team winner = m.getWinner();

        if (winner == null) { this.m_draws++; }
        else if (winner == this) { this.m_wins++; }
        else { this.m_losses++; }
    }
    
    private void match(Match m) {
        Team winner = m.getWinner();

        if (winner == null) { this.m_draws++; }
        else if (winner == this) { this.m_wins++; }
        else { this.m_losses++; }
        this.m_matches.add(m);
    }
    
    public String countryName() { return this.m_countryName; }
    
    public void printMatchRecord(PrintWriter writer) throws java.io.IOException {
        String stats = String.format("%-12s", this.m_countryName.trim());
        stats += String.format("%-12d", this.m_wins);
        stats += String.format("%-12d", this.m_losses);
        stats += String.format("%d", this.m_draws);
        writer.println(stats);
    }
    
    public void addPlayer (String name) {
        this.m_players.add(name);
    }
    
    public void printTeamStatistics(PrintWriter writer) throws java.io.IOException {
        
        // Print header
        writer.println(this.m_countryName + " - " + this.m_sport.getName());
        
        // Print player names
        writer.println("Atletas");
        Iterator<String> it = m_players.iterator();
        while (it.hasNext()) {
            String name = it.next();
            writer.println(name);
        }
        
        // Print matches
        writer.println(String.format("%-15s", "Adversários") + "Placar");
        Iterator<Match> it2 = m_matches.iterator();
        while (it2.hasNext()) {
            Match m = it2.next();
            m.printStatistics(writer, this);
        }
    }
    
    protected Sport getSport() { return this.m_sport; }
}