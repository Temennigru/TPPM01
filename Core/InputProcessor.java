package Core;
import java.io.File;
import java.util.Scanner;

public class InputProcessor {
	// le a linha inteira e separa strings nos " ; " 
	
	// diferentes arquivos de entrada:
	// esportes.txt     : int ; string - idEsporte ; nome 
	// selecoes.txt     : int ; int ; string - idSelecao ; idEsporte ; nomePais
	// atletas.txt      : int ; int ; string - id ; idSelecao ; nome 
	// partidas.txt     : int ; int ; int ; int ; int - id ; idSelecaoA ; idSelecaoB ; placarSelecaoA ; placarSelecaoB
	// estatisticas.txt : int ; int - idTipo ; (idEsporte ou idSelecao)
	
	// precisa adequar o processador ao arquivo de entrada para ele dividir corretamente
	
	Scanner dis=new Scanner(System.in);
    int a,b,c,d,e; // 1 a 5 numeros sao passados por LINHA do arquivo de entrada
    String texto; // no maximo 1 string sera passada por LINHA do arquivo de entrada
    String line; // guarda a linha INTEIRA com ; e sera separada depois
    String[] lineVector ;

    line = dis.nextLine(); //le 1,2,3,4,5

    //separa os valores por ponto e virgula
    lineVector = line.split(";");

    //passa os valores para inteiros
    a=Integer.parseInt(lineVector[0]);
    b=Integer.parseInt(lineVector[1]);
    c=Integer.parseInt(lineVector[2]);
    d=Integer.parseInt(lineVector[3]);
    e=Integer.parseInt(lineVector[4]);

    System.out.println("a="+a);
    System.out.println("b="+b);
    System.out.println("c="+c);
    System.out.println("d="+d);
    System.out.println("e="+e); 
	
}

	// 1: int, string
	// 2: int, int, string
	// 3: int, int, string (igual) 
	// 4: int, int, int, int, int
	// 5: int, int
