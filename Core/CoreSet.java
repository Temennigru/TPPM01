package Core;
import Sports.Sport;

public class CoreSet {
    Deque<Team> m_teams;
    Deque<Sport> m_sports;
    Deque<PrintData> m_print;
    
    protected class PrintData {
        protected int country;
        protected int sport;
    }

    private CoreSet() {}
    
    public CoreSet(String path) {
        this.m_teams = new Deque<Team>();
        this.m_sports = new Deque<Sport>();
        this.m_print = new Deque<PrintData>();
        this.m_path = path;
    }

    public main() {
        InputProcessor.process(this.m_teams, this.m_sports, this.m_print);
        
        
        for (int i = 0; i < this.m_print.size(); i++) {
            if (m_print[i].country < 0 && m_print[i].sport >= 0) {
                // Create out file
                String path = "estatistica-1-" + m_print[i].sport + ".txt";
                PrintWriter writer = new PrintWriter(path, "UTF-8");
                
                // Print header
                writer.println(m_sports[m_print[i].sport].getName());
                writer.println(String.format("%-12s", "Times") + String.format("%-12s", "V") +
                               String.format("%-12s", "E")     + String.format("%-12s", "D"));
                
                // Print team stats
                for (int j = 0; j < m_teams.size(); j++) {
                    
                }
            }
        }
        
        
    }

}