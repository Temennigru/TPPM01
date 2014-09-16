package Core;
import java.io.File;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.Map;
import Sports.*;

public class InputProcessor {
    
    public static void process (Map<Integer, Team> teams, Map<Integer, Sport> sports, Vector<PrintData> data) throws java.io.FileNotFoundException, java.io.IOException {

        // le a linha inteira e separa strings nos " ; "
	
        // diferentes arquivos de entrada:
        // esportes.txt     : int ; string - idEsporte ; nome
        // selecoes.txt     : int ; int ; string - idSelecao ; idEsporte ; nomePais
        // atletas.txt      : int ; int ; string - id ; idSelecao ; nome
        // partidas.txt     : int ; int ; int ; int ; int - id ; idSelecaoA ; idSelecaoB ; placarSelecaoA ; placarSelecaoB
        // estatisticas.txt : int ; int - idTipo ; (idEsporte ou idSelecao)
	
        // precisa adequar o processador ao arquivo de entrada para ele dividir corretamente
        
        
        
        // Scan sports input
        {
            Scanner dis = new Scanner(new File("esportes"+".txt"));
        
            while (dis.hasNext()) {

                String line; // guarda a linha INTEIRA com ; e sera separada depois

                String[] lineVector ;
                
                line = dis.nextLine();

                if (line.isEmpty()) continue;
        
                //separa os valores por ponto e virgula
                lineVector = line.split(";");
        
                if (lineVector[1].trim().equalsIgnoreCase("basquete")) {
                    Sport temp = new Basketball();
                    sports.put(Integer.parseInt(lineVector[0]), temp);
                }
                else if (lineVector[1].trim().equalsIgnoreCase("volei")) {
                    Sport temp = new IndoorVolleyball();
                    sports.put(Integer.parseInt(lineVector[0]), temp);
                }
                else if (lineVector[1].trim().equalsIgnoreCase("futebol de salão")) {
                    Sport temp = new IndoorFootball();
                    sports.put(Integer.parseInt(lineVector[0]), temp);
                }
                else if (lineVector[1].trim().equalsIgnoreCase("futebol")) {
                    Sport temp = new FieldFootball();
                    sports.put(Integer.parseInt(lineVector[0]), temp);
                }
                else if (lineVector[1].trim().equalsIgnoreCase("futebol de areia")) {
                    Sport temp = new BeachFootball();
                    sports.put(Integer.parseInt(lineVector[0]), temp);
                }
                else if (lineVector[1].trim().equalsIgnoreCase("volei de praia")) {
                    Sport temp = new BeachVolleyball();
                    sports.put(Integer.parseInt(lineVector[0]), temp);
                }
                else {
                    System.out.println("tretas de esporte - " + "\"" + lineVector[1].toLowerCase() + "\"");
                    System.exit(1);
                }
            }
            
            
        }
        
        // Scan teams input
        {
            Scanner dis = new Scanner(new File("selecoes"+".txt"));

            while (dis.hasNext()) {
                
                String line; // guarda a linha INTEIRA com ; e sera separada depois
                String[] lineVector ;
            
                line = dis.nextLine();

                if (line.isEmpty()) continue;

                //separa os valores por ponto e virgula
                lineVector = line.split(";");
            
                Team temp = new Team(lineVector[2], sports.get(Integer.parseInt(lineVector[1])));
            
            
                teams.put(Integer.parseInt(lineVector[0]), temp);
            }
        }
        
        // Scan players input
        {
            Scanner dis = new Scanner(new File("atletas"+".txt"));
            
            while (dis.hasNext()) {
                
                String line; // guarda a linha INTEIRA com ; e sera separada depois
                String[] lineVector ;
                
                line = dis.nextLine();

                if (line.isEmpty()) continue;

                //separa os valores por ponto e virgula
                lineVector = line.split(";");
                
                teams.get(Integer.parseInt(lineVector[1])).addPlayer(lineVector[2]);
            }
        }
        
        // Scan matches input
        {
            Scanner dis = new Scanner(new File("partidas"+".txt"));
            
            while (dis.hasNext()) {
                
                String line; // guarda a linha INTEIRA com ; e sera separada depois

                String[] lineVector ;
                
                line = dis.nextLine();

                if (line.isEmpty()) continue;

                //separa os valores por ponto e virgula
                lineVector = line.split(";");
                
                teams.get(Integer.parseInt(lineVector[1].trim())).match(
                                        teams.get(Integer.parseInt(lineVector[2].trim())) /*team 2*/,
                                        Integer.parseInt(lineVector[3].trim())            /*score 1*/,
                                        Integer.parseInt(lineVector[4].trim())            /*score 2*/,
                                        Integer.parseInt(lineVector[1].trim())            /*id*/);
            }
        }
        
        // Scan stats print input
        {
            Scanner dis = new Scanner(new File("estatisticas"+".txt"));
            
            while (dis.hasNext()) {
                
                String line; // guarda a linha INTEIRA com ; e sera separada depois
                String[] lineVector ;
                
                line = dis.nextLine();

                if (line.isEmpty()) continue;
                
                //separa os valores por ponto e virgula
                lineVector = line.split(";");
                
                PrintData temp = new PrintData();
                
                switch (Integer.parseInt(lineVector[0].trim())) {
                    case 1: {
                        temp.sport = Integer.parseInt(lineVector[1].trim());
                        temp.country = -1;
                        break;
                    }
                    case 2: {
                        temp.country = Integer.parseInt(lineVector[1].trim());
                        temp.sport = -1;
                        break;
                    }
                    default: {
                        System.out.println("me passaram um tipo errado");
                        System.exit(1);
                    }
                }
                
                data.add(temp);
                        
            }
        }
        
    }
        
    
	
}
