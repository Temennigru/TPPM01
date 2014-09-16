package Core;
import Sports.Sport;
import java.util.*;
import java.io.*;
import java.util.TreeMap;


public class CoreSet {
    Map<Integer, Team> m_teams;
    Map<Integer, Sport> m_sports;
    Vector<PrintData> m_print;
    
    public CoreSet() {
        this.m_teams = new TreeMap<Integer, Team>();
        this.m_sports = new TreeMap<Integer, Sport>();
        this.m_print = new Vector<PrintData>();
    }

    public void main() throws java.io.FileNotFoundException, java.io.IOException {
        InputProcessor.process(this.m_teams, this.m_sports, this.m_print);

        for (int i = 0; i < this.m_print.size(); i++) {
            // If print sport
            if (m_print.elementAt(i).country < 0 && m_print.elementAt(i).sport >= 0) {
                // Create out file
                String path = "estatistica-1-" + m_print.elementAt(i).sport + ".txt";
                PrintWriter writer = new PrintWriter(path);
                
                // Print header
                writer.println(m_sports.get(m_print.elementAt(i).sport).getName());
                writer.println(String.format("%-12s", "Times") + String.format("%-12s", "V") +
                               String.format("%-12s", "E")     + String.format("%s", "D"));
                
                // Print team match record
                for(Map.Entry<Integer, Team> entry : m_teams.entrySet()) {

                    Team value = entry.getValue();

                    if (value.getSport().getName() != this.m_sports.get(m_print.elementAt(i).sport).getName()) {
                        continue;
                    }
                    
                    value.printMatchRecord(writer);
                }

                writer.close();
                
            // If print country
            } else if (m_print.elementAt(i).country >= 0 && m_print.elementAt(i).sport < 0) {
                // Create out file
                String path = "estatistica-2-" + m_print.elementAt(i).country + ".txt";
                PrintWriter writer = new PrintWriter(path);
                
                // Print match stats
                this.m_teams.get(m_print.elementAt(i).country).printTeamStatistics(writer);
                
                writer.close();
                
            // Error State
            } else {
                System.out.println("Eh pra imprimir o que, caralho?");
                System.exit(1);
            }
        }
            
            
            
    }
        
}

