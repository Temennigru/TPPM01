public final class Match {
    public Team[] team = new Team[2];
    
    public int[] score = new int[2];
    
    Match (Team team1, Team team2, int score1, int score2, Sports.Sport Sport) {
        team[1] = team1;
        team[2] = team2;
        score[1] = score1;
        score[2] = score2;
    }
    
}