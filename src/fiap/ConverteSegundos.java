package fiap;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ConverteSegundos {

	public static void main(String[] args) {
		
		//instancia as variaveis, o scanner e o formatador de numero
		int inTempo = 0, outH, outM, outS, moduloH;
		Scanner sc = new Scanner(System.in);
		NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
		
		while (true) {
			
			//checa se não há nenhuma exceção
			try {
				
				//recebe os dados
				System.out.print("Insira o tempo em segundos: ");
				inTempo = sc.nextInt();
				System.out.println();
				
				//valida se o numero de segundos é maior que 0
				if(inTempo > 0) {
					//se for maior continua o programa
					break; 
				} else {
					//se for menor imprime a mensagem de erro e pede a informação novamente
					System.out.println("Insira um número de segundos maior que 0!"); 
					System.out.println();
				}
				
			//trata a exceção se existir
			} catch (InputMismatchException ex) {
				sc.next(); //limpa o input
				
				//imprime a mensagem de erro e pede a informação novamente
				System.out.println("Insira um número de segundos válido!"); 
				System.out.println();
				
			} 
			
			
				
		}
		
		//converte o tempo
		moduloH = inTempo % 3600;
		outH = inTempo / 3600;
		outM =  moduloH/ 60;
		outS = moduloH % 60;
		
		
		//devolve o resultado na tela apenas com as informações que forem maiores que 0
		System.out.println(nf.format(inTempo) + " segundos = " + 
				(outH > 0 ? (outH + " horas, ") : "") + 
				(outM > 0 ? outM + " minutos" : "") + 
				(outM > 0 && outS > 0 ? " e " : "") + 
				(outS > 0 ? outS + " segundos" : "") + ".");
		
		sc.close();
		
	}
	
}
