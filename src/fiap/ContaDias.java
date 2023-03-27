package fiap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaDias {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int diasMes = 0, diasAno, mes, ano;
		boolean bissexto;
		
		//recebe os valores
		while(true) {
		
			//checa se nao h� exce��o
			try {
				System.out.print("Insira a data (mm/aaaa): ");
				String[] dados = sc.nextLine().split("/");
				mes = Integer.parseInt(dados[0]);
				ano = Integer.parseInt(dados[1]);
				System.out.println();
				
				//checa se o mes � valido
					if(mes > 0 && mes <= 12) {
						//se for valido continua o programa
						break;
					} else {
						//se n�o for imprime a mensagem de erro e pede a informa��o novamente
						System.out.println("Insira uma data v�lida!");
						System.out.println();
					}
			
			//trata a exce��o se presente
			} catch (InputMismatchException exc) {
				sc.next(); //limpa o input
				
				//imprime a mensagem de erro e pede a informa��o novamente
				System.out.println("Insira uma data v�lida!");
				System.out.println();
			}
		}
	
		// checa se o ano � bissexto
		if (ano % 4 == 0) {
			if (ano % 100 != 0) {
				bissexto = true;			
			} else {
				if (ano % 400 == 0) {					
					bissexto = true;				
				} else {
					bissexto = false;
				}				
			}
		} else {
			bissexto = false;	
		}
	
		diasAno = bissexto ? 366 : 365;	
		
		// checa quantos dias tem o m�s inserido
		
		switch (mes) {
			case 1,3,5,7,8,10,12:
				diasMes = 31;
				break;
			case 4,6,9,11:
				diasMes = 30;
				break;
			case 2:
				diasMes = bissexto ? 29 : 28;
				break;			
		} 
		
		System.out.println("O m�s " + mes + " tem " + diasMes + " dias.");
		System.out.println("O ano " + ano + " tem " + diasAno + " dias.");
		
		sc.close();
	
	}	
}
