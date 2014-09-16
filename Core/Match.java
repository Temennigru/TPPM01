package Core;
import java.util.*;
import java.io.*;
import java.lang.Exception;
import java.io.PrintWriter;
import java.io.FileWriter;

public final class Match {
    Team[] m_team = new Team[2];
    Sports.Sport m_sport;
    int[] m_score = new int[2];
    int m_id;
    
    private Match() {}
    
    public Match (Team team1, Team team2, int score1, int score2, int matchId, Sports.Sport sport) {
        this.m_team[0] = team1;
        this.m_team[1] = team2;
        this.m_score[0] = score1;
        this.m_score[1] = score2;
        this.m_sport = sport;
        this.m_id = matchId;
    }
    
    public Team getWinner () {
        this.m_sport.reset();
        this.m_sport.score(0, this.m_score[0]);
        this.m_sport.score(1, this.m_score[1]);
        if (m_sport.victor() == 0) return null;
        return m_team[m_sport.victor() - 1];
    }
    
    public int getScore (Team team) {
             if (team.getSport().getClass() != this.m_sport.getClass()) { System.exit(1); }
        else if (this.m_team[0].countryName() == team.countryName())    { return this.m_score[0]; }
        else if (this.m_team[1].countryName() == team.countryName())    { return this.m_score[1]; }
        else                                                            { System.exit(1); }
        return 0;
    }
    
    public Team getAdversary (Team team) {
             if (team.getSport().getClass() != this.m_sport.getClass()) { System.exit(1); }
        else if (this.m_team[0].countryName() == team.countryName())    { return this.m_team[1]; }
        else if (this.m_team[1].countryName() == team.countryName())    { return this.m_team[0]; }
        else                                                            { System.exit(1); }
        return null;
    }
    
    public void printStatistics (PrintWriter writer, Team team) throws java.io.IOException {
        String match = String.format("%-15s", this.getAdversary(team).countryName());
        match += this.m_score[0] + "x" + this.m_score[1];
        writer.println(match);
    }
    
}