package Core;

public final class Match {
    Team[] m_team = new Team[2];
    Sports.Sport m_sport;
    int[] m_score = new int[2];
    
    private Match() {}
    
    public Match (Team team1, Team team2, int score1, int score2, Sports.Sport sport) {
        m_team[0] = team1;
        m_team[1] = team2;
        m_score[0] = score1;
        m_score[1] = score2;
        m_sport = sport;
    }
    
    public Team getWinner () {
        m_sport.reset();
        m_sport.score(0, this.m_score[0]);
        m_sport.score(1, this.m_score[1]);
        return m_team[m_sport.victor()];
    }
    
    public int getScore (Team team) throws InvalidMatchException {
             if (team.getSport().getClass() != this.m_sport.getClass()) { throw new InvalidMatchException; }
        else if (m_team[0].countryName() == team.countryName())         { return m_score[0]; }
        else if (m_team[1].countryName() == team.countryName())         { return m_score[1]; }
        else                                                            { throw new InvalidMatchException; }
    }
    
    public Team getAdversary (Team team) throws InvalidMatchException {
             if (team.getSport().getClass() != this.m_sport.getClass()) { throw new InvalidMatchException; }
        else if (m_team[0].countryName() == team.countryName())         { return m_team[1]; }
        else if (m_team[1].countryName() == team.countryName())         { return m_team[0]; }
        else                                                            { throw new InvalidMatchException; }
    }
    
    public void printStatistics (String path, Team team) {
        PrintWriter writer = new PrintWriter(new FileWriter(path, true), "UTF-8");
        String match = String.format("%-12s", this.getAdversary(team).countryName());
        match += this.score[0] + "x" + this.score[1];
        writer.println(match);
    }
    
}